package chapter12.code.listing.sample;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * DateTimePortlet class represents the portlet class responsible for
 * handling portlet requests.
 * 
 * @author asarin
 */
public class DateTimePortlet extends GenericPortlet {

	@RenderMode(name = "view")
	public void showHomePage(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		request.getPortletSession().setAttribute("username", request.getRemoteUser(), PortletSession.APPLICATION_SCOPE);
		getPortletContext().getRequestDispatcher(
				response.encodeURL("/WEB-INF/jsp/home.jsp")).include(request, response);
	}
}
