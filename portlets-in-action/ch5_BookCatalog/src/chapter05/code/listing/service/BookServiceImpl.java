package chapter05.code.listing.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import chapter05.code.listing.domain.Book;
import chapter05.code.listing.utils.BookDataObject;

public class BookServiceImpl implements BookService {
	private ServletContext context;
	
	public BookServiceImpl(ServletContext context) {
		this.context = context;
	}
	
	public List<Book> getBooks() {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		return bookCatalog.getBooks();
	}

	public List<Book> searchBooks(String bookName, String authorName) {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		List<Book> matchingBooks = new ArrayList<Book>();
		for(Book book : bookCatalog.getBooks()) {
			if(book.getName().contains(bookName) && book.getAuthor().contains(authorName)) {
				matchingBooks.add(book);
			}
		}
		return matchingBooks;
	}
	
	public void addBook(Book book) {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		bookCatalog.getBooks().add(book);
	}

	public void removeBook(Long isbnNumber) {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		bookCatalog.getBooks().remove(getBook(isbnNumber));
	}
	
	public boolean isUniqueISBN(Long isbnNumber) {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		boolean isUnique = true;
		for(Book book : bookCatalog.getBooks()) {
			if(book.getIsbnNumber().equals(isbnNumber)) {
				isUnique = false;
				break;
			}
		}
		return isUnique;
	}

	public Book getBook(Long isbnNumber) {
		BookDataObject bookCatalog = (BookDataObject) context.getAttribute("bookCatalog");
		Book matchingBook = null;
		for(Book book : bookCatalog.getBooks()) {
			if(book.getIsbnNumber().equals(isbnNumber)) {
				matchingBook = book;
				break;
			}
		}
		return matchingBook;
	}
}