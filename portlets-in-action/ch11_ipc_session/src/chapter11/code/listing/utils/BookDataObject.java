package chapter11.code.listing.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chapter11.code.listing.domain.Book;

public class BookDataObject {
	private List<Book> books = Collections.synchronizedList(new ArrayList<Book>());
	
	public BookDataObject() {
		books.add(new Book("java", "AspectJ in Action, Second Edition", "Ramnivas Laddad", Long.valueOf("1933988053"), 1));
		books.add(new Book("java", "ActiveMQ in Action", "Bruce Snyder, Dejan Bosanac, and Rob Davies", Long.valueOf("1933988940"), 2));
		books.add(new Book("java", "Hadoop in Action", "Chuck Lam", Long.valueOf("9781935182191"), 3));
		books.add(new Book("java", "JUnit in Action, Second Edition", "Petar Tahchiev, Felipe Leme, Vincent Massol, and Gary Gregory", Long.valueOf("9781935182023"), 4));
		books.add(new Book(".net", "Azure in Action", "Chris Hay, Brian H. Prince", Long.valueOf("9781935182481"), 5));
	}
	
	public List<Book> getBooks() {
		return books;
	}
}
