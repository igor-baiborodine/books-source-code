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
import com.inkwell.internet.slogan.util.WebKeys;

import com.liferay.portlet.asset.model.BaseAssetRenderer;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Rich Sezov
 */
public class SloganAssetRenderer extends BaseAssetRenderer {

    public SloganAssetRenderer(Slogan slogan) {
        _slogan = slogan;
    }

    public long getClassPK() {
        return _slogan.getSloganId();
    }

    public long getGroupId() {
        return _slogan.getGroupId();
    }

    public String getSummary() {
        return _slogan.getSloganText();
    }

    public String getTitle() {
        return "Slogan Contest Entry";
    }

    public long getUserId() {
        return _slogan.getUserId();
    }

    public String getUuid() {
        return _slogan.getUuid();
    }

    public String render(
            RenderRequest request, RenderResponse response,
            String template)
        throws Exception {

        if (template.equals(TEMPLATE_FULL_CONTENT)) {
            request.setAttribute(WebKeys.SLOGAN_ENTRY, _slogan);

            return "/html/" + template + ".jsp";
        }
        else {
            return null;
        }
    }

    private Slogan _slogan;

}
