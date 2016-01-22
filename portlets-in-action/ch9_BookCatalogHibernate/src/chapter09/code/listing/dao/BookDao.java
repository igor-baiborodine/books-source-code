package chapter09.code.listing.dao;

import java.util.List;

import chapter09.code.listing.domain.Book;

public interface BookDao {
	List<Book> getBooks();
	List<Book> searchBooks(String bookName, String authorName);
	void addBook(Book book);
	void removeBook(Long id);
	boolean isUniqueISBN(Long isbnNumber);
	Book getBook(Long id);
}
