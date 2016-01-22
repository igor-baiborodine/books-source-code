package chapter05.code.listing.service;

import java.util.List;

import chapter05.code.listing.domain.Book;

public interface BookService {
	List<Book> getBooks();
	void addBook(Book book);
	boolean isUniqueISBN(Long isbnNumber);
	Book getBook(Long isbnNumber);
	void removeBook(Long isbnNumber);
	List<Book> searchBooks(String bookName, String authorName);
}
