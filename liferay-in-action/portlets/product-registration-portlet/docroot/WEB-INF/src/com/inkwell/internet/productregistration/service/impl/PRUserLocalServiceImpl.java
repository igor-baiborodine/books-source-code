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

import com.inkwell.internet.productregistration.model.PRUser;
import com.inkwell.internet.productregistration.service.base.PRUserLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * <a href="PRUserLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Rich Sezov
 */
public class PRUserLocalServiceImpl extends PRUserLocalServiceBaseImpl {

    /**
     * Adds a Registered User object to the database as a new record.
     *
     * @param user
     * @return
     * @throws SystemException
     */
    public PRUser addPRUser(PRUser user, long userId)
        throws SystemException, PortalException {

        PRUser prUser =
            prUserPersistence.create(counterLocalService.increment(PRUser.class.getName()));

        prUser.setAddress1(user.getAddress1());
        prUser.setAddress2(user.getAddress2());
        prUser.setBirthDate(user.getBirthDate());
        prUser.setCity(user.getCity());
        prUser.setCompanyId(user.getCompanyId());
        prUser.setCountry(user.getCountry());
        prUser.setEmail(user.getEmail());
        prUser.setFirstName(user.getFirstName());
        prUser.setGroupId(user.getGroupId());
        prUser.setLastName(user.getLastName());
        prUser.setMale(user.getMale());
        prUser.setPhoneNumber(user.getPhoneNumber());
        prUser.setPostalCode(user.getPostalCode());
        prUser.setState(user.getState());
        prUser.setUserId(user.getUserId());

        resourceLocalService.addResources(
            prUser.getCompanyId(), prUser.getGroupId(),
            PRUser.class.getName(), false);

        return prUserPersistence.update(prUser, false);
    }

    /**
     * Gets a Registered User object from a Liferay User primary key or null if
     * it wasn't found.
     *
     * @param groupId
     * @param userId
     * @return
     * @throws SystemException
     */
    public PRUser getPRUser(long groupId, long userId)
        throws SystemException {

        List<PRUser> prUserList =
            prUserPersistence.findByG_U(groupId, userId);

        PRUser prUser = null;

        if (prUserList.size() > 0) {
            prUser = prUserList.get(0);
        }

        return prUser;
    }

}
