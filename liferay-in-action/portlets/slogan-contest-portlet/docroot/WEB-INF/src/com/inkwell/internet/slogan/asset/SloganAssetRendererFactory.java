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

package com.inkwell.internet.slogan.asset;

import com.inkwell.internet.slogan.model.Slogan;
import com.inkwell.internet.slogan.service.SloganLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

/**
 * @author Rich Sezov
 */
public class SloganAssetRendererFactory
    extends BaseAssetRendererFactory {

    public static final String CLASS_NAME = Slogan.class.getName();

    public static final String TYPE = "slogan";

    public AssetRenderer getAssetRenderer(long classPK, int type)
        throws PortalException, SystemException {

        Slogan slogan = SloganLocalServiceUtil.getSlogan(classPK);

        return new SloganAssetRenderer(slogan);
    }

    public String getClassName() {
        return CLASS_NAME;
    }

    public String getType() {
        return TYPE;
    }

}
