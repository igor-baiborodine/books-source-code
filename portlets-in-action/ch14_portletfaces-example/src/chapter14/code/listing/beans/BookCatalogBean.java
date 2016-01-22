package chapter14.code.listing.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.el.ELResolver;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;

import chapter14.code.listing.service.BookService;

@ManagedBean(name = "bookCatalogBean")
@SessionScoped
public class BookCatalogBean implements Serializable {
	private static final long serialVersionUID = -6642447430627752746L;
	private Book book = new Book();
	private Logger logger = Logger.getLogger(BookCatalogBean.class);
	private Map<String, String> errorMap = new HashMap<String, String>();

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}

	public String showAddBookForm() throws IOException {
		return "addBookForm";
	}

	public List<Book> getBooks() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELResolver elResolver = fc.getApplication().getELResolver();
		BookService bookService = (BookService) elResolver.getValue(fc
				.getELContext(), null, "bookService");
		return bookService.getBooks();
	}

	public void validateIsbn(ValueChangeEvent vce) {
		logger.info("Validating book ISBN Number");
		UIInput isbnComponent = (UIInput) vce.getComponent();
		Long isbnNumber = (Long) isbnComponent.getValue();
		logger.info("Book ISBN field value : " + isbnNumber); 

		FacesContext fc = FacesContext.getCurrentInstance();
		ELResolver elResolver = fc.getApplication().getELResolver();
		BookService bookService = (BookService) elResolver.getValue(fc
				.getELContext(), null, "bookService");
        Book matchingBook = bookService.getBook(Long.valueOf(isbnNumber));
        if(matchingBook != null) {
        	logger.info("ISBN number match found");
        	errorMap.put("isbnNumber", "Book with the same ISBN number already exists.");
        } else {
        	errorMap.remove("isbnNumber");
        }
	}

	public String addBook() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELResolver elResolver = fc.getApplication().getELResolver();
		BookService bookService = (BookService) elResolver.getValue(fc
				.getELContext(), null, "bookService");
		if(errorMap.isEmpty()) {
			bookService.addBook(book);
		}
		return "home";
	}

	public String removeBook() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String isbnNumber = fc.getExternalContext().getRequestParameterMap()
				.get("isbnNumber");
		logger.info(("removing book with isbnNumber: " + isbnNumber));
		ELResolver elResolver = fc.getApplication().getELResolver();
		BookService bookService = (BookService) elResolver.getValue(fc
				.getELContext(), null, "bookService");
		bookService.removeBook(Long.valueOf(isbnNumber));
		return "";
	}
}