package chapter06.code.listing.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import chapter06.code.listing.utils.BookDataObject;

public class BookCatalogContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent event) {
		event.getServletContext().removeAttribute("bookCatalog");
	}

	public void contextInitialized(ServletContextEvent event) {
		BookDataObject books = new BookDataObject();
		event.getServletContext().setAttribute("bookCatalog", books);
	}

}
