package chapter08.code.listing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import chapter08.code.listing.service.BookService;

/**
 * RemoveBookController handles removal of Book from the Catalog.
 * 
 * @author asarin
 *
 */
@Controller
@RequestMapping("VIEW")
public class RemoveBookController {
	@Autowired
	@Qualifier("myBookService")
	private BookService bookService;

	@ActionMapping(params="myaction=removeBook")
	public void removeBook(@RequestParam Long isbnNumber) {
		bookService.removeBook(isbnNumber);
	}
	
	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "errorPage";
	}
}
