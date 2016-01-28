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

package com.inkwell.internet.slogan.workflow;

import com.inkwell.internet.slogan.model.Slogan;
import com.inkwell.internet.slogan.service.SloganLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;

import java.io.Serializable;

import java.util.Locale;
import java.util.Map;

/**
 * @author Rich Sezov
 */
public class SloganWorkflowHandler extends BaseWorkflowHandler {

    public String getClassName() {
        return CLASS_NAME;
    }

    public String getType(Locale locale) {
        return LanguageUtil.get(locale, "model.resource." + CLASS_NAME);
    }

    public Object updateStatus(
            int status, Map<String, Serializable> workflowContext)
        throws PortalException, SystemException {

        long userId = GetterUtil.getLong(
            workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

        long resourcePrimKey = GetterUtil.getLong(
            workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext =
            (ServiceContext) workflowContext.get("serviceContext");

        return SloganLocalServiceUtil.updateStatus(
            userId, resourcePrimKey, status, serviceContext);
    }

    public static final String CLASS_NAME = Slogan.class.getName();
}
