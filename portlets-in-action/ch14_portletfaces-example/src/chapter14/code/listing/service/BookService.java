package chapter14.code.listing.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import chapter14.code.listing.beans.Book;

@ManagedBean(eager=true, name="bookService")
@ApplicationScoped
public class BookService {
	private List<Book> books = Collections
			.synchronizedList(new ArrayList<Book>());

	public BookService() {
		books.add(new Book("Java", "AspectJ in Action, Second Edition",
				"Ramnivas Laddad", Long.valueOf("1933988053")));
		books.add(new Book("Java", "ActiveMQ in Action",
				"Bruce Snyder, Dejan Bosanac, and Rob Davies", Long
						.valueOf("1933988940")));
		books.add(new Book("Java", "Hadoop in Action", "Chuck Lam", Long
				.valueOf("9781935182191")));
		books
				.add(new Book("Java", 
						"JUnit in Action, Second Edition",
						"Petar Tahchiev, Felipe Leme, Vincent Massol, and Gary Gregory",
						Long.valueOf("9781935182023")));
	}

	public List<Book> getBooks() {
		return books;
	}
	
	public void removeBook(Long isbnNumber) {
		getBooks().remove(getBook(isbnNumber));
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public Book getBook(Long isbnNumber) {
		Book matchingBook = null;
		for(Book book : getBooks()) {
			if(book.getIsbnNumber().equals(isbnNumber)) {
				matchingBook = book;
				break;
			}
		}
		return matchingBook;
	}
}