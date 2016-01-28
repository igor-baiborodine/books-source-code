/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferayinaction.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Hello You portlet, a simple example demonstrating
 * Portlet Modes, Portlet Actions, and Portlet Preferences.
 *
 * @author Rich Sezov
 *
 */
public class HelloYouPortlet extends GenericPortlet {

	public void init()
		throws PortletException {

		editJSP = getInitParameter("edit-jsp");
		viewJSP = getInitParameter("view-jsp");
	}


	public void doEdit(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		renderResponse.setContentType("text/html");
		PortletURL addNameURL = renderResponse.createActionURL();
		addNameURL.setParameter("addName", "addName");
		renderRequest.setAttribute("addNameURL", addNameURL.toString());
		include(editJSP, renderRequest, renderResponse);
	}


	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		PortletPreferences prefs = renderRequest.getPreferences();
		String username = (String) prefs.getValue("name", "no");
		if (username.equalsIgnoreCase("no")) {
			username = "";
		}
		renderRequest.setAttribute("userName", username);
		include(viewJSP, renderRequest, renderResponse);
	}

	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		String addName = actionRequest.getParameter("addName");
		if (addName != null) {
			PortletPreferences prefs = actionRequest.getPreferences();
			prefs.setValue("name", actionRequest.getParameter("username"));
			prefs.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		}
	}

	protected void include(
			String path, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher =
			getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		}
		else {
			portletRequestDispatcher.include(
				renderRequest, renderResponse);
		}
	}

	protected String editJSP;
	protected String viewJSP;

	private static Log _log = LogFactory.getLog(HelloYouPortlet.class);

}
