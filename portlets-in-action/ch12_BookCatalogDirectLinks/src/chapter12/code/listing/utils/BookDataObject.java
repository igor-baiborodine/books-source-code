package chapter12.code.listing.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chapter12.code.listing.domain.Book;

public class BookDataObject {
	private List<Book> books = Collections.synchronizedList(new ArrayList<Book>());
	
	public BookDataObject() {
		books.add(new Book("AspectJ in Action, Second Edition", "Ramnivas Laddad", Long.valueOf("1933988053"), ".docx"));
		books.add(new Book("ActiveMQ in Action", "Bruce Snyder, Dejan Bosanac, and Rob Davies", Long.valueOf("1933988940"), ".docx"));
		books.add(new Book("Hadoop in Action", "Chuck Lam", Long.valueOf("9781935182191"), ".docx"));
		books.add(new Book("JUnit in Action, Second Edition", "Petar Tahchiev, Felipe Leme, Vincent Massol, and Gary Gregory", Long.valueOf("9781935182023"), ".docx"));
	}
	
	public List<Book> getBooks() {
		return books;
	}
}
