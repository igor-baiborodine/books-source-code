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

package com.inkwell.internet.productregistration.social;

import com.inkwell.internet.productregistration.model.PRProduct;
import com.inkwell.internet.productregistration.model.PRRegistration;
import com.inkwell.internet.productregistration.service.PRProductLocalServiceUtil;
import com.inkwell.internet.productregistration.service.PRRegistrationLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.social.model.BaseSocialActivityInterpreter;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityFeedEntry;


public class RegistrationActivityInterpreter
    extends BaseSocialActivityInterpreter {

    public String[] getClassNames() {

        return _CLASS_NAMES;
    }

    @Override
    protected SocialActivityFeedEntry doInterpret(
            SocialActivity activity, ThemeDisplay themeDisplay)
        throws Exception {

        PermissionChecker permissionChecker =
            themeDisplay.getPermissionChecker();

        PRRegistration registration =
            PRRegistrationLocalServiceUtil.getPRRegistration(
                activity.getClassPK());

        if (!permissionChecker.hasPermission(
                registration.getGroupId(), PRRegistration.class.getName(),
                registration.getPrimaryKey(), ActionKeys.VIEW)) {

            return null;
        }

        // Link

        String link = StringPool.BLANK;

        // Title

        String key = "activity-product-registration-add-registration";

        PRProduct product = PRProductLocalServiceUtil.getPRProduct(
            registration.getProductId());

        String title = getTitle(
            activity, key, product.getProductName(), link, themeDisplay);

        // Body

        String body = StringPool.BLANK;

        return new SocialActivityFeedEntry(link, title, body);
    }

    protected String getTitle(
        SocialActivity activity, String key, String content, String link,
        ThemeDisplay themeDisplay) {

        String userName = getUserName(activity.getUserId(), themeDisplay);

        String text = HtmlUtil.escape(cleanContent(content));

        if (Validator.isNotNull(link)) {
            text = wrapLink(link, text);
        }

        String groupName = StringPool.BLANK;

        if (activity.getGroupId() != themeDisplay.getScopeGroupId()) {
            groupName = getGroupName(activity.getGroupId(), themeDisplay);
        }

        String pattern = key;

        if (Validator.isNotNull(groupName)) {
            pattern += "-in";
        }

        return themeDisplay.translate(
            pattern, new Object[] {userName, text, groupName});
    }

    private static final String[]_CLASS_NAMES = new String[] {
        PRRegistration.class.getName()
    };

}
