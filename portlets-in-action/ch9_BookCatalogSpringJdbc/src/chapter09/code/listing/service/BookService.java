package chapter09.code.listing.service;

import java.util.List;

import chapter09.code.listing.base.BookAlreadyExistsException;
import chapter09.code.listing.base.UserNotLoggedInException;
import chapter09.code.listing.domain.Book;
import chapter09.code.listing.domain.ToC;

public interface BookService {
	List<Book> getBooks();
	void addBook(Book book, String user) throws BookAlreadyExistsException, UserNotLoggedInException;
	boolean isUniqueISBN(Long isbnNumber);
	Book getBook(Long isbnNumber);
	void removeBook(Long isbnNumber);
	List<Book> searchBooks(String bookName, String authorName);
	void uploadToc(ToC toc);
}
