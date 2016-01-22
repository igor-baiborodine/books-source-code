package chapter07.code.listing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.Controller;

import chapter07.code.listing.domain.Book;
import chapter07.code.listing.exceptions.MissingParameterException;
import chapter07.code.listing.service.BookService;

/**
 * Controller that handles portlet requests in VIEW mode.
 * The controller is responsible for showing list of books, add/edit/remove book.
 * 
 * @author asarin
 *
 */
public class ViewModeController implements Controller {
	private BookService bookService;
	private Logger logger = Logger.getLogger(ViewModeController.class);
	
	public void handleActionRequest(ActionRequest request, ActionResponse response)
			throws Exception {
		if("addBook".equalsIgnoreCase(request.getParameter("myaction"))) {
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
			if(isbnNumber == null || isbnNumber.trim().equalsIgnoreCase("")) {
				errorMap.put("isbnNumber", "Please enter ISBN number");
			}
			if(isbnNumber == null || !StringUtils.isNumeric(isbnNumber)) {
				errorMap.put("isbnNumber", "Please enter a valid ISBN number");
			} 
			if(isbnNumber != null && !isbnNumber.trim().equalsIgnoreCase("") && StringUtils.isNumeric(isbnNumber) && !bookService.isUniqueISBN(Long.valueOf(isbnNumber))) {
				errorMap.put("isbnNumber", "Please enter a unique ISBN number");
			}
			
			//-- contains property name to property value map, for re-rendering the form
			Map<String, String> valuesMap = new HashMap<String, String>();
			valuesMap.put("name", name);
			valuesMap.put("author", author);
			valuesMap.put("isbnNumber", isbnNumber);
			
			if(!errorMap.isEmpty()) {
				request.setAttribute("errors", errorMap);
				request.setAttribute("book", valuesMap);
				response.setRenderParameter("myaction", "addBookForm");
			} else {
				//-- add the book to the catalog
				bookService.addBook(new Book(name, author, Long.valueOf(isbnNumber)));
			}
		}
		
		if("editBook".equalsIgnoreCase(request.getParameter("myaction"))) {
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
			}
		}
		
		if("removeBook".equalsIgnoreCase(request.getParameter("myaction"))) {
			bookService.removeBook(Long.valueOf(request.getParameter("isbnNumber")));
		}
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public ModelAndView handleRenderRequest(RenderRequest request,
			RenderResponse response) throws Exception {
		logger.info("Entering render request method");
		ModelAndView modelAndView = null;
		Map<String, Object> modelMap = new ModelMap();
		if(request.getParameter("myaction") == null) {
			List<Book> books = bookService.getBooks();
			modelMap.put("books", books);
			modelAndView = new ModelAndView("books", modelMap);
		}
		
		if("addBookForm".equalsIgnoreCase(request.getParameter("myaction"))) {
			modelAndView = new ModelAndView("addBook");
		}
		
		if("editBookForm".equalsIgnoreCase(request.getParameter("myaction"))) {
			String isbnNumber = request.getParameter("isbnNumber");
			if(isbnNumber == null) {
				throw new MissingParameterException("IsbnNumber parameter not found in the request");
			}
			modelMap.put("book", bookService.getBook(Long.valueOf(isbnNumber)));
			modelAndView = new ModelAndView("editBook", modelMap);
		}
		return modelAndView;
	}
}
