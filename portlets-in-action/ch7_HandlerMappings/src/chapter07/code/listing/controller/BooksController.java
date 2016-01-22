package chapter07.code.listing.controller;

import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import chapter07.code.listing.domain.Book;
import chapter07.code.listing.service.BookService;

/**
 * Controller for showing the home page of the Book Catalog portlet.
 * 
 * @author asarin
 *
 */
public class BooksController extends AbstractController {
	private BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
		// -- as we are not going to have an action request sent to this
		// -- controller, this method has not been implemented
	}

	public ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		Map<String, Object> modelMap = new ModelMap();
		List<Book> books = bookService.getBooks();
		modelMap.put("books", books);
		return  new ModelAndView("books", modelMap);
	}
}
