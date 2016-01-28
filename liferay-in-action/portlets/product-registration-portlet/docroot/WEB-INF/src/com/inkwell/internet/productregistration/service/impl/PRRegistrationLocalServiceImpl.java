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

package com.inkwell.internet.productregistration.service.impl;

import java.util.List;

import com.inkwell.internet.productregistration.model.PRRegistration;
import com.inkwell.internet.productregistration.model.PRUser;
import com.inkwell.internet.productregistration.service.base.PRRegistrationLocalServiceBaseImpl;
import com.inkwell.internet.productregistration.social.ProductActivityKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;

/**
 * <a href="PRRegistrationLocalServiceImpl.java.html"><b><i>View Source</i></b>
 * </a>
 *
 * @author Rich Sezov
 */
public class PRRegistrationLocalServiceImpl
    extends PRRegistrationLocalServiceBaseImpl {

    /**
     * Adds a newly created registration to the database.
     *
     * @param reg
     * @return
     * @throws SystemException
     */

    public PRRegistration addRegistration(PRRegistration reg)
        throws SystemException, PortalException {

        PRRegistration registration =
            prRegistrationPersistence.create(
                counterLocalService.increment(PRRegistration.class.getName()));

        registration.setCompanyId(reg.getCompanyId());
        registration.setDatePurchased(reg.getDatePurchased());
        registration.setGroupId(reg.getGroupId());
        registration.setHowHear(reg.getHowHear());
        registration.setProductId(reg.getProductId());
        registration.setPrUserId(reg.getPrUserId());
        registration.setSerialNumber(reg.getSerialNumber());
        registration.setWherePurchased(reg.getWherePurchased());

        resourceLocalService.addResources(
            registration.getCompanyId(), registration.getGroupId(),
            PRRegistration.class.getName(), false);

        // Social

        // try to get the user from the pruser for social
        // there will be no link if the user wasn't logged in

        PRUser prUser = prUserPersistence.findByPrimaryKey(
            registration.getPrUserId());
        User user = userPersistence.fetchByPrimaryKey(prUser.getUserId());

        if (user != null) {
            socialActivityLocalService.addActivity(
                user.getUserId(), reg.getGroupId(),
                PRRegistration.class.getName(), registration.getPrimaryKey(),
                ProductActivityKeys.ADD_REGISTRATION, StringPool.BLANK, 0);
        }

        return prRegistrationPersistence.update(registration, false);
    }

    /**
     * Gets all registrations out of the database.
     *
     * @return
     * @throws SystemException
     */
    public List<PRRegistration> getAllRegistrations(long groupId)
        throws SystemException {

        List<PRRegistration> registrations =
            prRegistrationPersistence.findByGroupId(groupId);
        return registrations;
    }
}
