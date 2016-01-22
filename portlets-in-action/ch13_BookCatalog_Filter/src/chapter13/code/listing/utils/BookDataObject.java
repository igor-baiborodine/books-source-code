package chapter13.code.listing.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chapter13.code.listing.domain.Book;

public class BookDataObject {
	private List<Book> books = Collections.synchronizedList(new ArrayList<Book>());
	
	public BookDataObject() {
		books.add(new Book("java", "AspectJ in Action, Second Edition", "Ramnivas Laddad", Long.valueOf("1933988053")));
		books.add(new Book("java", "ActiveMQ in Action", "Bruce Snyder, Dejan Bosanac, and Rob Davies", Long.valueOf("1933988940")));
		books.add(new Book("java", "Hadoop in Action", "Chuck Lam", Long.valueOf("9781935182191")));
		books.add(new Book("java", "JUnit in Action, Second Edition", "Petar Tahchiev, Felipe Leme, Vincent Massol, and Gary Gregory", Long.valueOf("9781935182023")));
		books.add(new Book(".net", "Azure in Action", "Chris Hay, Brian H. Prince", Long.valueOf("9781935182481")));
	}
	
	public List<Book> getBooks() {
		return books;
	}
}
