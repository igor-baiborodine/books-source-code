package chapter09.code.listing.service;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import chapter09.code.listing.domain.Book;

public class MyFirstHibernateExample {
	private static Logger logger = Logger.getLogger(MyFirstHibernateExample.class);

	public static void main(String args[]) {
		logger.info("Starting main method");
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Book book = new Book("Portlets in Action", "Ashish Sarin", 9781935182542L);
		book.setCreatedBy("asarin");
		book.setCreatedDate(new java.util.Date());
		book.setActive(1);
		session.save(book);
		logger.info("Book saved with id " + book.getId());
		session.getTransaction().commit();
		session.close();
	}

	private static SessionFactory getSessionFactory()  {
		SessionFactory sessionFactory = new AnnotationConfiguration()
				.addAnnotatedClass(Book.class).setProperty(
						"hibernate.connection.driver_class",
						"com.mysql.jdbc.Driver").setProperty(
						"hibernate.connection.url",
						"jdbc:mysql://localhost/myportaldb?useUnicode=true&")
				.setProperty("hibernate.connection.username", "root")
				.setProperty("hibernate.connection.password", "asarin")
				.buildSessionFactory();
		return sessionFactory;
	}
}