/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.inkwell.internet.productregistration.registration.portlet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.inkwell.internet.productregistration.model.PRRegistration;
import com.inkwell.internet.productregistration.model.PRUser;
import com.inkwell.internet.productregistration.model.impl.PRRegistrationImpl;
import com.inkwell.internet.productregistration.model.impl.PRUserImpl;
import com.inkwell.internet.productregistration.service.PRRegistrationLocalServiceUtil;
import com.inkwell.internet.productregistration.service.PRUserLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * The Product Registration Portlet allows customers to register their products
 * electronically without having to fill out the reply card and send it back.
 *
 * @author Rich Sezov
 */
public class ProductRegistrationPortlet extends MVCPortlet {

    /**
     * Navigate to the Register Product page.
     *
     * @param request
     * @param response
     */
    public void addRegistration(
        ActionRequest request, ActionResponse response) {

        ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        PRRegistration registration = new PRRegistrationImpl();
        PRUser prUser = new PRUserImpl();

        if (themeDisplay.isSignedIn()) {
            User user = themeDisplay.getUser();
            // Now that we have a user, let's see if the portal
            // knows anything about him or her that we can use on the form
            List<Address> addresses = Collections.EMPTY_LIST;
            Address homeAddr = null;

            try {
                addresses =
                    AddressLocalServiceUtil.getAddresses(
                        user.getCompanyId(), User.class.getName(),
                        user.getUserId());
            }
            catch (SystemException ex) {
                // No addresses available; do nothing
            }
            if (addresses.size() > 0) {
                // simple flow; just grab the first one
                homeAddr = addresses.get(0);
            }
            // populate what we can of our registration
            prUser.setFirstName(user.getFirstName());
            prUser.setLastName(user.getLastName());
            prUser.setEmail(user.getEmailAddress());
            try {
                prUser.setBirthDate(user.getBirthday());
                boolean male = user.getMale();
                if (male) {
                    prUser.setGender("male");
                }
                else {
                    prUser.setGender("female");
                }
                prUser.setMale(male);
            }
            catch (PortalException e) {
                prUser.setBirthDate(new Date());
            }
            catch (SystemException e) {
                prUser.setMale(true);
            }

            if (homeAddr != null) {
                prUser.setAddress1(homeAddr.getStreet1());
                prUser.setAddress2(homeAddr.getStreet2());
                prUser.setCity(homeAddr.getCity());
                prUser.setPostalCode(homeAddr.getZip());
                prUser.setCountry(homeAddr.getCountry().toString());
            }
            // Our regUser might have stuff in it now
            registration.setDatePurchased(new Date());
        }
        else {
            // user isn't logged in
            registration.setDatePurchased(new Date());
            Calendar dob = CalendarFactoryUtil.getCalendar();
            dob.set(Calendar.YEAR, 1970);
            prUser.setBirthDate(dob.getTime());
            prUser.setGender("");
        }

        request.setAttribute("regUser", prUser);
        request.setAttribute("registration", registration);
        response.setRenderParameter("jspPage", viewAddRegistrationJSP);
    }

    /**
     * Takes a submitted registration and adds it to the database if it passes
     * validation.
     *
     * @param request
     * @param response
     */
    public void registerProduct(
        ActionRequest request, ActionResponse response)
        throws Exception {

        PRUser regUser = ActionUtil.prUserFromRequest(request);
        PRRegistration registration =
            ActionUtil.prRegistrationFromRequest(request);
        ArrayList<String> errors = new ArrayList<String>();
        ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();

        User liferayUser = UserLocalServiceUtil.getUser(userId);

        boolean userValid = ProdRegValidator.validateUser(regUser, errors);
        boolean regValid =
            ProdRegValidator.validateRegistration(registration, errors);

        if (userValid && regValid) {
            // TODO: Logic needs to change here for multiple registrations and
            // to check for logged-in users
            PRUser user = null;

            // check to see if user is a guest
            if (liferayUser.isDefaultUser()) {
                userId = 0;
                user = PRUserLocalServiceUtil.addPRUser(regUser, userId);
            }
            else {
                // Check to see if we have a PR User from the Liferay user ID
                user =
                    PRUserLocalServiceUtil.getPRUser(
                        themeDisplay.getScopeGroupId(), userId);

                if (user == null) {
                    // Create a new mapping
                    regUser.setUserId(userId);
                    user =
                        PRUserLocalServiceUtil.addPRUser(regUser, userId);
                }
            }

            registration.setPrUserId(user.getPrUserId());
            PRRegistrationLocalServiceUtil.addRegistration(registration);
            SessionMessages.add(request, "registration-saved-successfully");
            response.setRenderParameter("jspPage", viewThankYouJSP);
        }
        else {
            for (String error : errors) {
                SessionErrors.add(request, error);
            }
            SessionErrors.add(request, "error-saving-registration");
            response.setRenderParameter("jspPage", viewAddRegistrationJSP);
            request.setAttribute("regUser", regUser);
            request.setAttribute("registration", registration);
        }
    }

    protected String viewAddRegistrationJSP =
        "/registration/view_add_registration.jsp";
    protected String viewThankYouJSP = "/registration/view_thank_you.jsp";

}
