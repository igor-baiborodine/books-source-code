/*
 * Copyright (c) 2000-2007 Liferay, Inc. All rights reserved.
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

package com.liferayinaction.ipc;

import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Rich Sezov
 */
public class CatcherPortlet extends GenericPortlet {

    public void init()
        throws PortletException {

        editJSP = getInitParameter("edit-jsp");
        viewJSP = getInitParameter("view-jsp");
    }

    public void doEdit(RenderRequest req, RenderResponse res)
        throws IOException, PortletException {

        if (req.getPreferences() == null) {
            super.doEdit(req, res);
        }
        else {
            include(editJSP, req, res);
        }
    }

    public void doView(RenderRequest req, RenderResponse res)
        throws IOException, PortletException {

        include(viewJSP, req, res);
    }

    protected void include(
            String path, RenderRequest req, RenderResponse res)
        throws IOException, PortletException {

        PortletRequestDispatcher prd =
            getPortletContext().getRequestDispatcher(path);

        if (prd == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            prd.include(req, res);
        }
    }

    @ProcessEvent(qname = "{http://liferay.com/events}ipc.pitch")
    public void catchBall(EventRequest request, EventResponse response) {
        Event event = request.getEvent();
        String pitch = (String) event.getValue();
        response.setRenderParameter("pitch", pitch);
    }

    protected String editJSP;
    protected String viewJSP;

    private static Log _log = LogFactory.getLog(CatcherPortlet.class);
}
