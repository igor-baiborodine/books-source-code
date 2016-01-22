package chapter07.code.listing.controller;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import chapter07.code.listing.domain.Book;
import chapter07.code.listing.exceptions.MissingParameterException;
import chapter07.code.listing.service.BookService;

/**
 * Controller for 'Edit' book functionality.
 * 
 * @author asarin
 *
 */
public class EditBookController extends AbstractController {
	private BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
		String name = request.getParameter("name"); 
		String author = request.getParameter("author");
		String isbnNumber = request.getParameter("isbnNumber");
		//-- we have to do explicit binding as we don't have the concept of command or form-backing object
		//-- when using Controller interface. The support for base classes for Command and Form Controllers
		//-- has been deprecated as of Spring 3.0
		//--contains map of field names to error message
		
		Map<String, String> errorMap = new HashMap<String, String>(); 
		
		if (name == null || name.trim().equalsIgnoreCase("")) {
			errorMap.put("name", "Please enter book name");
		}
		if(author == null || author.trim().equalsIgnoreCase("")) {
			errorMap.put("author", "Please enter author name");
		}
		
		//-- contains property name to property value map, for re-rendering the form
		Map<String, String> valuesMap = new HashMap<String, String>();
		valuesMap.put("name", name);
		valuesMap.put("author", author);
		valuesMap.put("isbnNumber", isbnNumber);
		
		if(!errorMap.isEmpty()) {
			request.setAttribute("errors", errorMap);
			request.setAttribute("book", valuesMap);
			response.setRenderParameter("myaction", "editBookForm");
		} else {
			//-- add the book to the catalog
			bookService.editBook(new Book(name, author, Long.valueOf(isbnNumber)));
			//--set the response parameter explicitly to blank, to go back to the home page of the portlet
			//-- by default the ParameterHandlerInterceptor retains the value of myaction request
			//--parameter when calling the corresponding renderRequest
			response.setRenderParameter("myaction", "");
		}
	}

	public ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		String isbnNumber = request.getParameter("isbnNumber");
		if(isbnNumber == null) {
			throw new MissingParameterException("IsbnNumber parameter not found in the request");
		}
		ModelMap modelMap = new ModelMap();
		modelMap.put("book", bookService.getBook(Long.valueOf(isbnNumber)));
		return new ModelAndView("editBook", modelMap);
	}
}
