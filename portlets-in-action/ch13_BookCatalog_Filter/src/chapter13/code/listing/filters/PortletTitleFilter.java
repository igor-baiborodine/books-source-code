package chapter13.code.listing.filters;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;

import org.apache.log4j.Logger;

public class PortletTitleFilter implements RenderFilter {
	private String reqParamName;
	private Properties props = new Properties();
	private Logger logger = Logger.getLogger(PortletTitleFilter.class);

	public void init(FilterConfig filterConfig) throws PortletException {
		reqParamName = filterConfig.getInitParameter("reqParamName");
		InputStream inStream = this.getClass().getClassLoader()
				.getResourceAsStream("title.properties");
		try { 
			props.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doFilter(RenderRequest request, RenderResponse response,
			FilterChain filterChain) throws IOException, PortletException {
		logger.info("PortletTitleFilter ---> Pre-processing request");
		filterChain.doFilter(request, response);
		//--post process response to set portlet title
		String reqParamValue = request.getParameter(reqParamName);
		logger.info("Setting portlet title.....");
		if (request.getPortletMode() == PortletMode.VIEW) {
			String title = props.getProperty("portlet.title." + reqParamValue);
			if (title == null) { // --if no title found, set the default value
									// for the title
				response.setTitle(props.getProperty("portlet.title.default"));
			} else {
				response.setTitle(props.getProperty("portlet.title."
						+ reqParamValue));
			}
		}
		if(request.getPortletMode() == PortletMode.EDIT) {
			response.setTitle(props.getProperty("portlet.title.preferences"));
		}
		if(request.getPortletMode() == PortletMode.HELP) {
			response.setTitle(props.getProperty("portlet.title.help"));
		}
	}

	public void destroy() {

	}

}
