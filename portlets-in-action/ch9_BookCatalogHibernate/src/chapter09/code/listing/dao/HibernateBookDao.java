package chapter09.code.listing.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import chapter09.code.listing.domain.Book;

@Repository("bookDao")
public class HibernateBookDao implements BookDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Book> getBooks() {
		return sessionFactory.getCurrentSession().createQuery("from MyBook as book where book.active=1").list();
	}

	public List<Book> searchBooks(String bookName, String authorName) {
		return null;
	}

	public void addBook(final Book book) {
		book.setActive(1);
		sessionFactory.getCurrentSession().save(book);
	}

	public Book getBook(Long id) {
		String hql = "from MyBook as book where book.active=1 and id=" + id;
		return (Book) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
	}

	public boolean isUniqueISBN(Long isbnNumber) {
		String hql = "from MyBook as book where book.active=1 and book.isbnNumber=" + isbnNumber;
		Book book = (Book)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		if(book == null) {
			return true;
		} else {
			return false;
		}
	}

	public void removeBook(Long book_id) {
		String hql = "from MyBook as book where book.id=" + book_id;
		Book book = (Book)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		if(book != null) {
			book.setActive(0);
			sessionFactory.getCurrentSession().save(book);
		}
	}
}