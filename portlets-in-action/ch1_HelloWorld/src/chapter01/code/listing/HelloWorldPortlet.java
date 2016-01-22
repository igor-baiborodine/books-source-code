package chapter01.code.listing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderMode;

/**
 * A Simple Hello World portlet which writes the message directly to the
 * response stream.
 * 
 * @author asarin
 */
public class HelloWorldPortlet extends GenericPortlet {
	/**
	 * Render methods for the view mode. This methods is invoked when render
	 * request is sent to the portlet and the current portlet mode is 'VIEW'.
	 * 
	 * @param request
	 * @param response
	 * @throws PortletException
	 * @throws IOException
	 */
	@RenderMode(name = "VIEW")
	public void sayHello(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello World");
	}
}
