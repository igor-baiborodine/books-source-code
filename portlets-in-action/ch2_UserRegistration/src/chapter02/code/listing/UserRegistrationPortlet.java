package chapter02.code.listing;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * UseRegistrationPortlet class extends the GenericPortlet abstract class to
 * implement the portlet functionality.
 * 
 * @author asarin
 * 
 */
public class UserRegistrationPortlet extends GenericPortlet {
	private String defaultEmail;

	/*
	 * Overrides the init method of the GenericPortlet class to obtain the value
	 * of the defaultEmail initialization parameter specified in portlet.xml
	 * file. (non-Javadoc)
	 * 
	 * @see javax.portlet.GenericPortlet#init()
	 */
	public void init() {
		defaultEmail = getPortletConfig().getInitParameter("defaultEmail");
	}

	/**
	 * Renders the registration form or success JSP based on the value of
	 * request attribute actionStatus.
	 * 
	 * @param request
	 * @param response
	 * @throws PortletException
	 * @throws IOException
	 */
	@RenderMode(name = "VIEW")
	public void renderForm(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// -- dispatch request to success.jsp if actionStatus is success
		if ("success".equalsIgnoreCase((String) request
				.getAttribute("actionStatus"))) {
			PortletURL homeUrl = response.createRenderURL();
			
			request.setAttribute("homeUrl", homeUrl);
			getPortletContext()
					.getRequestDispatcher("/WEB-INF/jsp/success.jsp").include(
							request, response);
			return;
		}
		// -- create action and render URLs for the registration form.
		// -- Reset hyperlink fires a render request and Submit button
		// -- results in an action request
		PortletURL registerUserActionUrl = response.createActionURL();
		registerUserActionUrl.setParameter(ActionRequest.ACTION_NAME,
				"registerUserAction");
		PortletURL resetRenderUrl = response.createRenderURL();
		request.setAttribute("registerUserActionUrl", registerUserActionUrl);
		request.setAttribute("resetRenderUrl", resetRenderUrl);

		// -- if actionStatus is error then show the registration form populated
		// -- with values that were entered by the user
		if (!"error".equalsIgnoreCase((String) request
				.getAttribute("actionStatus"))) {
			request.setAttribute("email", defaultEmail);
		}
		getPortletContext().getRequestDispatcher(
				"/WEB-INF/jsp/registrationForm.jsp").include(request, response);
	}

	/**
	 * Registers the user with the system. The current implementation of this
	 * method doesn't save user information.
	 * 
	 * @param request
	 * @param response
	 * @throws PortletException
	 * @throws IOException
	 */
	@ProcessAction(name = "registerUserAction")
	public void registerUser(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		String email = request.getParameter("email");
		// --set the information entered by the user on the registration
		// --form as request attribute.
		// -- NOTE : You can't transfer complex objects
		// -- from action request to render request using setRenderParameter
		//-- method
		request.setAttribute("user", new User(
				request.getParameter("firstName"), request
						.getParameter("lastName"), email));
		
		//-- if email is not entered, show an error message. the
		//-- message is read from the resource bundle and forwarded
		//-- to render request as request attribute
		if (email == null || email.trim().equals("")) {
			ResourceBundle bundle = getPortletConfig().getResourceBundle(
					request.getLocale());
			request.setAttribute("errorMsg", bundle
					.getString("email.errorMsg.missing"));
			
			//--set actionStatus to error
			request.setAttribute("actionStatus", "error");
		} else {
			// --save the user information in the database - not implemented yet
			// -- to show the success page, pass the information of success to
			// render method
			request.setAttribute("actionStatus", "success");
		}
	}

	/**
	 * Renders the preferences page for the portlet.
	 * 
	 * @param request
	 * @param response
	 * @throws PortletException
	 * @throws IOException
	 */
	@RenderMode(name = "EDIT")
	public void renderPrefs(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		getPortletContext()
				.getRequestDispatcher("/WEB-INF/jsp/preferences.jsp").include(
						request, response);
	}

	/**
	 * Renders the help page for the portlet.
	 * 
	 * @param request
	 * @param response
	 * @throws PortletException
	 * @throws IOException
	 */
	@RenderMode(name = "HELP")
	public void renderHelp(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		getPortletContext().getRequestDispatcher("/WEB-INF/jsp/help.jsp")
				.include(request, response);
	}

}
