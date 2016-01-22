package chapter03.code.listing.service;

import java.util.List;

import chapter03.code.listing.domain.Book;
/**
 * Represents the service interface for book related operations.
 * 
 * @author asarin
 *
 */
public interface BookService {
	List<Book> getBooks();
	void addBook(Book book);
	boolean isUniqueISBN(Long isbnNumber);
	Book getBook(Long isbnNumber);
	void removeBook(Long isbnNumber);
	List<Book> searchBooks(String bookName, String authorName);
}
