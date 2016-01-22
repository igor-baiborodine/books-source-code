package chapter08.code.listing.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import chapter08.code.listing.domain.Book;
@Service(value="myBookService")
public class BookServiceImpl implements BookService {
	private List<Book> books = Collections.synchronizedList(new ArrayList<Book>());

	public BookServiceImpl() {
		books.add(new Book("AspectJ in Action, Second Edition", "Ramnivas Laddad", Long.valueOf("1933988053")));
		books.add(new Book("ActiveMQ in Action", "Bruce Snyder, Dejan Bosanac, and Rob Davies", Long.valueOf("1933988940")));
		books.add(new Book("Hadoop in Action", "Chuck Lam", Long.valueOf("9781935182191")));
		books.add(new Book("JUnit in Action, Second Edition", "Petar Tahchiev, Felipe Leme, Vincent Massol, and Gary Gregory", Long.valueOf("9781935182023")));
	}

	public List<Book> getBooks() {
		return books;
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public void removeBook(Long isbnNumber) {
		synchronized(books) {
			books.remove(getBook(isbnNumber));
		}
	}
	
	public boolean isUniqueISBN(Long isbnNumber) {
		boolean isUnique = true;
		for(Book book : books) {
			if(book.getIsbnNumber().equals(isbnNumber)) {
				isUnique = false;
				break;
			}
		}
		return isUnique;
	}

	public Book getBook(Long isbnNumber) {
		Book matchingBook = null;
		Book returnBook = null;

		synchronized (books) {
			for (Book book : books) {
				if (book.getIsbnNumber().equals(isbnNumber)) {
					matchingBook = book;
					break;
				}
			}
			// --create shallow copy of the Book object
			if (matchingBook != null) {
				returnBook = new Book();
				returnBook.setAuthor(matchingBook.getAuthor());
				returnBook.setIsbnNumber(matchingBook.getIsbnNumber());
				returnBook.setName(matchingBook.getName());
			}
		}
		return returnBook;
	}
	
	public void editBook(Book book) {
		Long isbnNumber = book.getIsbnNumber();
		Book matchingBook = null;
		
		synchronized (books) {
			for (Book book_ : books) {
				if (book_.getIsbnNumber().equals(isbnNumber)) {
					matchingBook = book_;
					break;
				}
			}
			books.remove(matchingBook);
			books.add(book);
		}
	}
}
