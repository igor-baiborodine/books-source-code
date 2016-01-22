package chapter11.code.listing.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chapter11.code.listing.domain.Book;

public class BookDataObject {
	private List<Book> books = Collections.synchronizedList(new ArrayList<Book>());
	
	public BookDataObject() {
		books.add(new Book("java", "Book Title 1", "Author 1", Long.valueOf("1"), 1));
		books.add(new Book("java", "Book Title 2", "Author 2", Long.valueOf("2"), 2));
		books.add(new Book("java", "Book Title 3", "Author 3", Long.valueOf("3"), 3));
		books.add(new Book("java", "Book Title 4", "Author 4", Long.valueOf("4"), 4));
		books.add(new Book("java", "Book Title 5", "Author 5", Long.valueOf("5"), 5));
	}
	
	public List<Book> getBooks() {
		return books;
	}
}
