package chapter12.code.listing.sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;

/**
 * DateTimePortlet class represents the portlet class responsible for
 * handling portlet requests.
 * 
 * @author asarin
 */
public class DateTimePortlet extends GenericPortlet {
	private Logger logger = Logger.getLogger(DateTimePortlet.class);
	
	@RenderMode(name = "view")
	public void showHomePage(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		List<String> userRoles = new ArrayList<String>();
		try {
			logger.info("User id of the current user is : " + request.getRemoteUser());
			List<Role> roles = RoleLocalServiceUtil.getUserRoles(Long.valueOf(request.getRemoteUser()));
			for(Role role : roles) {
				logger.info("Role name associated with user Id : " + request.getRemoteUser() + " is " + role.getName());
				userRoles.add(role.getName());
			}
			request.getPortletSession().setAttribute("userRoles", userRoles, PortletSession.APPLICATION_SCOPE);
		} catch (Exception e) {
			//..do nothing
		}
		getPortletContext().getRequestDispatcher(
				response.encodeURL("/WEB-INF/jsp/home.jsp")).include(request, response);
	}
}
