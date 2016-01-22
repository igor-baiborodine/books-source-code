package chapter07.code.listing.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import chapter07.code.listing.service.BookService;

/**
 * Controller for 'Remove' book functionality.
 * 
 * @author asarin
 *
 */
public class RemoveBookController extends AbstractController {
	private BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
		bookService.removeBook(Long.valueOf(request.getParameter("isbnNumber")));
		response.setRenderParameter("myaction", "");
	}

	public ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		return null;
	}
}
