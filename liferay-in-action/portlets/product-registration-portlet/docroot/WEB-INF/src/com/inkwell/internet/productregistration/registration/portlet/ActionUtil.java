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

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import com.inkwell.internet.productregistration.model.PRProduct;
import com.inkwell.internet.productregistration.model.PRRegistration;
import com.inkwell.internet.productregistration.model.PRUser;
import com.inkwell.internet.productregistration.model.impl.PRProductImpl;
import com.inkwell.internet.productregistration.model.impl.PRRegistrationImpl;
import com.inkwell.internet.productregistration.model.impl.PRUserImpl;
import com.inkwell.internet.productregistration.service.PRProductLocalServiceUtil;
import com.inkwell.internet.productregistration.service.PRRegistrationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;



/**
 *
 * @author Rich Sezov
 *
 */
public class ActionUtil {

    /**
     * Used by the view.jsp to grab the products from the database.
     * @param request
     * @return
     */
    public static List<PRProduct> getProducts(RenderRequest request) {
        ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long groupId = themeDisplay.getScopeGroupId();

        List<PRProduct> tempResults;

        try {
            tempResults = PRProductLocalServiceUtil.getAllProducts(groupId);
        }

        catch (SystemException ex) {
            tempResults  = Collections.EMPTY_LIST;

        }

        return tempResults;

    }

    public static List<PRRegistration> getRegistrations(RenderRequest request) {
        ThemeDisplay themeDisplay =
             (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long groupId = themeDisplay.getScopeGroupId();
        List<PRRegistration> tempResults;

        try {
            tempResults = PRRegistrationLocalServiceUtil.getAllRegistrations(groupId);
        }

        catch (SystemException se) {
            tempResults = Collections.EMPTY_LIST;
        }

        return tempResults;
        }



    /**
     * Creates a PRUser object out of fields from the request.
     *
     * @param request
     * @return
     */
    public static PRUser prUserFromRequest(ActionRequest request) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
       PRUser prUser = new PRUserImpl();

        prUser.setCompanyId(themeDisplay.getCompanyId());
        prUser.setGroupId(themeDisplay.getScopeGroupId());
        prUser.setFirstName(ParamUtil.getString(request, "firstName"));
        prUser.setLastName(ParamUtil.getString(request, "lastName"));
        prUser.setAddress1(ParamUtil.getString(request, "address1"));
        prUser.setAddress2(ParamUtil.getString(request, "address2"));
        prUser.setCity(ParamUtil.getString(request, "city"));
        prUser.setState(ParamUtil.getString(request, "state"));
        prUser.setPostalCode(ParamUtil.getString(request, "postalCode"));
        prUser.setPhoneNumber(ParamUtil.getString(request, "phoneNumber"));
        prUser.setCountry(ParamUtil.getString(request, "country"));
        prUser.setEmail(ParamUtil.getString(request, "emailAddress"));
        String gender = ParamUtil.getString(request, "gender");

        int birthDateMonth = ParamUtil.getInteger(request, "birthDateMonth");
        int birthDateDay = ParamUtil.getInteger(request, "birthDateDay");
        int birthDateYear = ParamUtil.getInteger(request, "birthDateYear");

        try {

            prUser.setBirthDate(PortalUtil.getDate(birthDateMonth, birthDateDay, birthDateYear, new PortalException()));

        } catch (PortalException ex) {
            prUser.setBirthDate(new Date());
        }

        if (!gender.equals("")) {

            if (gender.equalsIgnoreCase("male")) {
                prUser.setMale(true);
                prUser.setGender("male");

            } else {
                prUser.setMale(false);
                prUser.setGender("female");
            }

        } else {
            prUser.setGender(null);
        }

        return prUser;

    }

    /**
    * Creates a PRRegistration object out of values from the request.
    * @param request
    * @return
    */
    public static PRRegistration prRegistrationFromRequest(ActionRequest request) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        PRRegistration registration = new PRRegistrationImpl();

        registration.setCompanyId(themeDisplay.getCompanyId());
        registration.setGroupId(themeDisplay.getScopeGroupId());

        int datePurchasedMonth = ParamUtil.getInteger(request, "datePurchasedMonth");
        int datePurchasedDay = ParamUtil.getInteger(request, "datePurchasedDay");
        int datePurchasedYear = ParamUtil.getInteger(request, "datePurchasedYear");

        try {
            registration.setDatePurchased(PortalUtil.getDate(datePurchasedMonth, datePurchasedDay, datePurchasedYear, new PortalException()));
        } catch (PortalException ex) {
            registration.setDatePurchased(new Date());
        }

        registration.setHowHear(ParamUtil.getString(request, "howHear"));
        registration.setProductId(Long.parseLong(ParamUtil.getString(request, "productType")));
        registration.setPrUserId(ParamUtil.getLong(request, "regUserId"));
        registration.setSerialNumber(ParamUtil.getString(request, "productSerialNumber"));
        registration.setWherePurchased(ParamUtil.getString(request, "wherePurchase"));

        return registration;

    }

    /**
     * Creates a PRProduct object out of values from the request.
     * @param request
     * @return
     */
    public static PRProduct productFromRequest (ActionRequest request) {
       ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
       PRProduct product = new PRProductImpl();

       product.setCompanyId(themeDisplay.getCompanyId());
       product.setGroupId(themeDisplay.getScopeGroupId());
       product.setProductName(ParamUtil.getString(request, "productName"));
       product.setSerialNumber(ParamUtil.getString(request, "productSerial"));

       return product;
    }

}
