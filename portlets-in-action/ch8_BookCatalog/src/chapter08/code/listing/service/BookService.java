package chapter08.code.listing.service;

import java.util.List;

import chapter08.code.listing.domain.Book;

/**
 * Service interface for the BookCatalog portlet.
 * 
 * @author asarin
 *
 */
public interface BookService {
	/**
	 * Retrieve book list.
	 * 
	 * @return all books in the catalog
	 */
	List<Book> getBooks();
	
	/**
	 * Adds a book to the catalog
	 * 
	 * @param book to added to the catalog
	 */
	void addBook(Book book);
	
	/**
	 * Checks if the ISBN number already exists in the catalog.
	 * 
	 * @param isbnNumber isbnNumber to check for.
	 * 
	 * @return true if there is no book with matching isbnNumber is found in the catalog
	 */
	boolean isUniqueISBN(Long isbnNumber);
	
	/**
	 * Retrieve a book based on its ISBN number.
	 * 
	 * @param isbnNumber ISBN number of the book which needs to be retrieved
	 * @return book with the specified ISBN number
	 */
	Book getBook(Long isbnNumber);
	
	/**
	 * Remove a book from the catalog.
	 * 
	 * @param isbnNumber the ISBN number of the book that needs to be removed from the catalog
	 */
	void removeBook(Long isbnNumber);
	
	/**
	 * Update the Book in the catalog.
	 * 
	 * @param book the modified Book
	 */
	void editBook(Book book);
}
