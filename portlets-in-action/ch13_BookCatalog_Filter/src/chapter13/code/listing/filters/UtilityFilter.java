package chapter13.code.listing.filters;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;

import org.apache.log4j.Logger;

public class UtilityFilter implements ActionFilter, RenderFilter {
	private Logger logger = Logger.getLogger(UtilityFilter.class);

	public void init(FilterConfig filterConfig) throws PortletException {

	}

	public void doFilter(ActionRequest request, ActionResponse response,
			FilterChain filterChain) throws IOException, PortletException {
		logger.info("UtilityFilter ---> Pre-processing request");
		StringBuffer sb = new StringBuffer();
		String httpMethod = request.getMethod();
		if ("GET".equalsIgnoreCase(httpMethod)) {
			sb.append("WARNING: Action request makes use of GET HTTP method");
		}

		String actionName = request.getParameter(ActionRequest.ACTION_NAME);
		if (actionName == null || "".equals(actionName)) {
			sb
					.append("WARNING: Action request doesn't contain javax.portlet.action parameter. Are you using annotations ?");
		}
		request.setAttribute("warningMsg", sb.toString());
		logger.info("UtilityFilter - Pre-processing complete");
		filterChain.doFilter(request, response);
		logger.info("UtilityFilter - Post-processing complete");
	}

	public void doFilter(RenderRequest request, RenderResponse response,
			FilterChain filterChain) throws IOException, PortletException {
		logger.info("doFilter method of UtilitFilter for RenderRequest");
		String warningMsg = (String) request.getAttribute("warningMsg");
		if (warningMsg != null && !warningMsg.equals("")) {
			response.getWriter().append("<b>" + warningMsg + "</b>");
		}
		filterChain.doFilter(request, response);
	}

	public void destroy() {

	}
}