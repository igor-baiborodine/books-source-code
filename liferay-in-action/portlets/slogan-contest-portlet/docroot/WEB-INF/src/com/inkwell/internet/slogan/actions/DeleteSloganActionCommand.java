/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.inkwell.internet.slogan.actions;

import com.inkwell.internet.slogan.service.SloganLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.ActionCommand;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Rich Sezov
 */
public class DeleteSloganActionCommand implements ActionCommand {

    public boolean processCommand(
            PortletRequest request, PortletResponse response)
        throws PortletException {

        long sloganKey = ParamUtil.getLong(request, "resourcePrimKey");

        if (Validator.isNotNull(sloganKey)) {
            try {
                SloganLocalServiceUtil.deleteSlogan(sloganKey);
            }
            catch (PortalException e) {
                SessionErrors.add(request, "error-deleting");
                return false;
            }
            catch (SystemException e) {
                SessionErrors.add(request, "error-deleting");
                return false;
            }
            SessionMessages.add(request, "slogan-deleted");
            return true;
        }
        else {
            SessionErrors.add(request, "error-deleting");
            return false;
        }
    }
}
