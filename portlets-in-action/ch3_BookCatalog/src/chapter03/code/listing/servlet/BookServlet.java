package chapter03.code.listing.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import chapter03.code.listing.domain.Book;
import chapter03.code.listing.service.BookService;
import chapter03.code.listing.service.BookServiceImpl;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 6141948500774706345L;
	private Logger logger = Logger.getLogger(BookServlet.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = (String) request.getAttribute("myaction");
		logger.info("Value of myaction attribute, in doGet method is : "
				+ action);

		BookService bookService = new BookServiceImpl(this.getServletContext());
		if (action != null && action.equalsIgnoreCase("showCatalog")) {
			request.setAttribute("books", bookService.getBooks());
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
			dispatcher.include(request, response);
		}
		if (action != null && action.equalsIgnoreCase("showSearchResults")) {
			request.setAttribute("books", request.getAttribute("matchingBooks"));
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
			dispatcher.include(request, response);
		}
		if (action != null
				&& (action.equalsIgnoreCase("uploadTocForm") || action
						.equalsIgnoreCase("uploadTocAction"))) {
			request.setAttribute("books", bookService.getBooks());
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsp/uploadForm.jsp");
			dispatcher.include(request, response);
		}
		if (action != null
				&& (action.equalsIgnoreCase("addBookForm") || action
						.equalsIgnoreCase("addBookAction"))) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsp/addBookForm.jsp");
			dispatcher.include(request, response);
		}
		if (action != null && action.equalsIgnoreCase("print")) {
			request.setAttribute("books", bookService.getBooks());
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsp/printCatalog.jsp");
			dispatcher.include(request, response);
		}
		if (action != null && action.equalsIgnoreCase("removeBookAction")) {
			logger.info("Removing book from catalog");
			bookService.removeBook(Long.valueOf(request
					.getParameter("isbnNumber")));
			request.setAttribute("books", bookService.getBooks());
		}
		if (action != null && action.equalsIgnoreCase("error")) {
			request.setAttribute("exceptionMsg", request.getParameter("exceptionMsg"));
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.include(request, response);
		}
		if (action != null && action.equalsIgnoreCase("refreshResults")) {
			String bookNameSearchField = (String) request.getSession().getAttribute("bookNameSearchField");
			String authorNameSearchField = (String) request.getSession().getAttribute("authorNameSearchField");
			if(bookNameSearchField == null) {
				bookNameSearchField = "";
			}
			if(authorNameSearchField == null) {
				authorNameSearchField = "";
			}
			logger.info("Searching for books with name : " + bookNameSearchField + " and author name : " + authorNameSearchField);
			List<Book> matchingBooks = bookService.searchBooks(bookNameSearchField, authorNameSearchField);
			request.setAttribute("books", matchingBooks);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
			dispatcher.include(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String myaction = (String) request.getAttribute("myaction");
		logger
				.info("Value of myaction received by BookServlet in doPost method "
						+ myaction);
		BookService bookService = new BookServiceImpl(this
				.getServletContext());

		if(myaction != null && myaction.equalsIgnoreCase("searchBookAction")) {
			logger.info("Searching for books with name : " + request.getParameter("bookNameSearchField") + " and author name : " + request.getParameter("authorNameSearchField"));
			List<Book> matchingBooks = bookService.searchBooks(request.getParameter("bookNameSearchField"), request.getParameter("authorNameSearchField"));
			request.setAttribute("matchingBooks", matchingBooks);
		}
		
		if (myaction != null && myaction.equalsIgnoreCase("addBookAction")) {
			logger.info("Adding a book to the catalog");
			String name = request.getParameter("name");
			String author = request.getParameter("author");
			String isbnNumber = request.getParameter("isbnNumber");

			logger.info("Book name: " + name + ", author : " + author
					+ ", ISBN number: " + isbnNumber);

			// --contains map of field names to error message
			Map<String, String> errorMap = new HashMap<String, String>();

			if (name == null || name.trim().equalsIgnoreCase("")) {
				errorMap.put("name", "Please enter book name");
			}
			if (author == null || author.trim().equalsIgnoreCase("")) {
				errorMap.put("author", "Please enter author name");
			}
			if (isbnNumber == null || isbnNumber.trim().equalsIgnoreCase("")) {
				errorMap.put("isbnNumber", "Please enter ISBN number");
			}
			if (isbnNumber == null || !StringUtils.isNumeric(isbnNumber)) {
				errorMap.put("isbnNumber", "Please enter a valid ISBN number");
			}

			// --set errors attribute so that JSP page can show error message
			// -- In case of JetSpeed this attribute will not be able to make it
			// to the following render method
			request.setAttribute("errors", errorMap);

			// --if no error found, go ahead and save the book
			if (errorMap.isEmpty()) {
				logger.info("adding book to the data store");
				bookService.addBook(new Book(name, author, Long
						.valueOf(isbnNumber)));
			} else {
				logger
						.info("validation error occurred. re-showing the add book form");
				// -- contains property name to property value map, for
				// re-rendering
				// the form
				Map<String, String> valuesMap = new HashMap<String, String>();
				valuesMap.put("name", name);
				valuesMap.put("author", author);
				valuesMap.put("isbnNumber", isbnNumber);

				// --set the valuesMap as 'book' request attribute. JSP page
				// will
				// use this to show the value
				// --of properties in case form validation fails.
				// -- In case of JetSpeed this attribute will not be able to
				// make it
				// to the following render method
				request.setAttribute("book", valuesMap);
			}
		}
	}
}