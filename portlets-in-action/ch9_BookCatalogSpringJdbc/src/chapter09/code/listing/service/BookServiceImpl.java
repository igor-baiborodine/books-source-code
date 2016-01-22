package chapter09.code.listing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chapter09.code.listing.base.BookAlreadyExistsException;
import chapter09.code.listing.base.UserNotLoggedInException;
import chapter09.code.listing.dao.BookDao;
import chapter09.code.listing.dao.ToCDao;
import chapter09.code.listing.domain.Book;
import chapter09.code.listing.domain.ToC;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Autowired
	@Qualifier("bookDao")
	private BookDao bookDao;
	
	@Autowired
	@Qualifier("tocDao")
	private ToCDao tocDao;
	
	public List<Book> getBooks() {
		return bookDao.getBooks();
	}

	public List<Book> searchBooks(String bookName, String authorName) {
		return bookDao.searchBooks(bookName, authorName);
	}
	
	public void addBook(Book book, String user) throws BookAlreadyExistsException, UserNotLoggedInException {
		if(user == null || "".equals(user)) {
			throw new UserNotLoggedInException("Please login to add book");
		}
		if(bookDao.isUniqueISBN(book.getIsbnNumber())) { 
			book.setCreatedBy(user);
			bookDao.addBook(book);
		} else {
			throw new BookAlreadyExistsException("Book with ISBN number : " + book.getIsbnNumber() + " already exists in the catalog");
		}
	}
	
	@Transactional
	public void removeBook(Long book_id) {
		bookDao.removeBook(book_id);
		tocDao.removeToc(book_id);
	}
	
	public boolean isUniqueISBN(Long isbnNumber) {
		return bookDao.isUniqueISBN(isbnNumber);
	}

	public Book getBook(Long isbnNumber) {
		return bookDao.getBook(isbnNumber);
	}
	
	@Transactional
	public void uploadToc(ToC toc) {
		tocDao.removeToc(toc.getBook_id());
		tocDao.uploadToc(toc);
	}
}