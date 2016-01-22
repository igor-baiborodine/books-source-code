package chapter14.code.listing.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BookCatalogContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent event) {
		event.getServletContext().removeAttribute("bookCatalog");
	}

	public void contextInitialized(ServletContextEvent event) {
		BookDataObject books = new BookDataObject();
		event.getServletContext().setAttribute("bookCatalog", books);
	}

}
