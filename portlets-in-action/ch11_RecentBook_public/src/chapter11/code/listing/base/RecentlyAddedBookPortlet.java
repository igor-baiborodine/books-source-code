package chapter11.code.listing.base;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import chapter11.code.listing.domain.Book;
import chapter11.code.listing.service.BookService;
import chapter11.code.listing.service.BookServiceImpl;
import chapter11.code.listing.utils.Constants;

public class RecentlyAddedBookPortlet extends GenericPortlet {
	private Logger logger = Logger.getLogger(RecentlyAddedBookPortlet.class);
	
	@RenderMode(name="view")
	public void showLatestBook(RenderRequest request, RenderResponse response)
	throws IOException, PortletException {
		logger.info("Entering showLatestBook render method");
		String isbnNumber = request.getParameter("recentBookIsbn");
		logger.info("recentBookIsbn public render parameter value " + isbnNumber);
		BookService bookService = new BookServiceImpl(getPortletContext());
		Book book = null;
		if(isbnNumber != null) {
			book = bookService.getBook(Long.valueOf(isbnNumber));
		}
		request.setAttribute("book", book);
		getPortletContext().getRequestDispatcher(
				response.encodeURL(Constants.PATH_TO_JSP_PAGE
						+ "recentPortletHome.jsp")).include(request, response);
	}
}