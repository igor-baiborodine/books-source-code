package chapter07.code.listing.wrapping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
/**
 * Hello World portlet from chapter 1. The PortletWrappingController wraps this portlet instance
 * and is responsible for managing it .Refer portletWrappingController-portlet.xml
 * web application context XML to view the configuration of PortletWrappingController.
 *  
 * @author asarin
 *
 */
public class HelloWorldPortlet extends GenericPortlet {
	@RenderMode(name = "VIEW")
	public void view(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello World");
	}
}
