package chapter12.code.listing.sample;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

/**
 * DateTimePortlet class represents the portlet class responsible for handling
 * portlet requests.
 * 
 * @author asarin
 */
public class DateTimePortlet extends GenericPortlet {
	@RenderMode(name = "view")
	public void showHomePage(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		ResourceURL dateTimeResourceURL = response.createResourceURL();
		dateTimeResourceURL.setResourceID("dateTime");
		request.setAttribute("dateTimeResourceURL", dateTimeResourceURL);
		
		getPortletContext().getRequestDispatcher(
				response.encodeURL("/WEB-INF/jsp/home.jsp")).include(request,
				response);
	}

	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException, PortletException {
		response.getCacheControl().setExpirationTime(100);
		OutputStream outStream = response.getPortletOutputStream();
		StringBuffer buffer = new StringBuffer();
		if (request.isUserInRole("User")) {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"dd-MMM-yyyy hh:mm:ss a");
			buffer.append("Hello World (<i> " + sdf.format(new Date())
					+ " </i>)");
		} else {
			buffer.append("<font color=\"red\"> You are not authorized to view server date/time");
		}
		outStream.write(buffer.toString().getBytes());
	}
}
