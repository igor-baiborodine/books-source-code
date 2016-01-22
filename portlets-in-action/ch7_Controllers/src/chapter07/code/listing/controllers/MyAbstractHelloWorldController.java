package chapter07.code.listing.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

/**
 * Controller that extends AbstractController class of Spring. This is hello world
 * example using AbstractController. 
 * 
 * @author asarin
 *
 */
public class MyAbstractHelloWorldController extends AbstractController {

	public void handleActionRequestInternal(ActionRequest arg0, ActionResponse arg1)
			throws Exception {
		// -- as we are not going to have an action request sent to this
		// --portlet, this method is empty
	}

	public ModelAndView handleRenderRequestInternal(RenderRequest arg0,
			RenderResponse arg1) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("helloWorldMessage", "Hello World");
		return new ModelAndView("helloWorld", model);
	}

}