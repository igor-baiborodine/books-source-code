package chapter13.code.listing.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class HyperlinkFilter implements RenderFilter {
	private Logger logger = Logger.getLogger(HyperlinkFilter.class);
	private List<String> searchNames = new ArrayList<String>();
	private List<String> replacements = new ArrayList<String>();

	public void init(FilterConfig filterConfig) throws PortletException {
		Enumeration<String> initParamNames = filterConfig
				.getInitParameterNames();
		while (initParamNames.hasMoreElements()) {
			String name = initParamNames.nextElement();
			String value = filterConfig.getInitParameter(name);
			searchNames.add(name);
			replacements.add("<a href='#' onclick='javascript:window.open("
					+ "\"" + value + "\"" + ");'>" + name + "</a>");
		}
	}

	public void doFilter(RenderRequest request, RenderResponse response,
			FilterChain filterChain) throws IOException, PortletException {
		logger.info("HyperlinkFilter ---> Pre-processing request....adding CharResponseWrapper");
		CharResponseWrapper responseWrapper = new CharResponseWrapper(response);
		filterChain.doFilter(request, responseWrapper);

		logger.info("Post-processing response");
		String str = responseWrapper.toString();

		logger.info(searchNames.toArray() + " " + replacements.toArray());
		String[] searchNamesArray = new String[searchNames.size()];
		String[] replacementsArray = new String[replacements.size()];

		str = StringUtils.replaceEach(str, searchNames
				.toArray(searchNamesArray), replacements
				.toArray(replacementsArray));
		logger.info("Writing response string .... " + str);
		response.getWriter().write(str);
	}

	public void destroy() {
	}
}
