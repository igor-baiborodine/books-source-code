package chapter07.code.listing.controller;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.Controller;
/**
 * Controller that handles portlet requests in EDIT mode.
 * 
 * @author asarin
 *
 */
public class EditModeController implements Controller {

	public void handleActionRequest(ActionRequest request, ActionResponse response)
			throws Exception {
		//-- do nothing
	}

	public ModelAndView handleRenderRequest(RenderRequest request,
			RenderResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("modeMessage", "This page will contain the preferences for the Book Catalog portlet");		
		return new ModelAndView("editMode", model);
	}
}
