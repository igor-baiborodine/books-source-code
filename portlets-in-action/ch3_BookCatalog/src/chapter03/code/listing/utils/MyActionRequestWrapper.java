package chapter03.code.listing.utils;

import javax.portlet.ActionRequest;
import javax.portlet.filter.ActionRequestWrapper;

public class MyActionRequestWrapper extends ActionRequestWrapper {

	public MyActionRequestWrapper(ActionRequest request) {
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
