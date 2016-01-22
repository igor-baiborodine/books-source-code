package chapter03.code.listing.utils;

import javax.portlet.RenderRequest;
import javax.portlet.filter.RenderRequestWrapper;

public class MyRenderRequestWrapper extends RenderRequestWrapper {

	public MyRenderRequestWrapper(RenderRequest request) {
		super(request);
	}
	public Object getAttribute(String attributeName) {
		Object attribute;
		if(attributeName != null && attributeName.equalsIgnoreCase("myparam")) {
			attribute = getRequest().getParameter(attributeName);
		} else {
			attribute = getRequest().getAttribute(attributeName);
		}
		return attribute;
	}
}
