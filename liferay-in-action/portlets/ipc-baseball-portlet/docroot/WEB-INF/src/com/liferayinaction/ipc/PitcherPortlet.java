/**
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
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This portlet demonstrates the new Event model in JSR-286 that is used to
 * achieve Inter-Portlet Communication. This portlet will "throw" an event out
 * there for another portlet to catch.
 *
 * @author Rich Sezov
 */
public class PitcherPortlet extends GenericPortlet {

    public void init()
        throws PortletException {

        viewJSP = getInitParameter("view-jsp");
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

    /**
     * Since Portlet 2.0's GenericPortlet class lets you call methods from
     * processAction via annotations, we don't even need to touch the
     * processAction method to call our actions.
     */
    @ProcessAction(name = "pitchBall")
    public void pitchBall(ActionRequest request, ActionResponse response) {
        String pitchType = null;
        // Send an Event that the ball has been pitched.
        Random random = new Random(System.currentTimeMillis());
        int pitch = random.nextInt(3) + 1;
        switch (pitch) {
        case 1:
            pitchType = "Fast Ball";
            break;
        case 2:
            pitchType = "Curve Ball";
            break;
        case 3:
            pitchType = "Slider";
            break;
        // should never print
        default:
            pitchType = "Screw Ball";
        }

        QName qName =
            new QName("http://liferay.com/events", "ipc.pitch");
        response.setEvent(qName, pitchType);
    }

    protected String viewJSP;

    private static Log _log = LogFactory.getLog(PitcherPortlet.class);

}
