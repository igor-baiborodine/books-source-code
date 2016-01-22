package chapter12.code.listing.base;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import chapter12.code.listing.domain.Book;
import chapter12.code.listing.service.BookService;
import chapter12.code.listing.service.BookServiceImpl;
import chapter12.code.listing.utils.Constants;

public class RecentlyAddedBookPortlet extends GenericPortlet {
	private Logger logger = Logger.getLogger(RecentlyAddedBookPortlet.class);
	
	protected void doHeaders(RenderRequest request, RenderResponse response) {
		super.doHeaders(request, response);
	}
	
	@RenderMode(name = "VIEW")
	public void showRecentlyAddedBook(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		getPortletContext().setAttribute("recentlyAddedBookPortletNamespace", response.getNamespace());
		getPortletContext().getRequestDispatcher(
				response.encodeURL(Constants.PATH_TO_JSP_PAGE
						+ "recentPortletHome.jsp")).include(request, response);
	}

	@RenderMode(name="view")
	public void serveResource(ResourceRequest request, ResourceResponse response)
	throws IOException, PortletException {
		logger.info("Entering showLatestBook method");
		String isbnNumber = (String) request.getParameter("isbn");
		BookService bookService = new BookServiceImpl(getPortletContext());
		Book book = null;
		if(isbnNumber != null) {
			if(bookService.isRecentBook(Long.valueOf(isbnNumber))) {
				book = bookService.getBook(Long.valueOf(isbnNumber));
			} else {
				book = bookService.getRecentBook();
			}
		} else {
			book = bookService.getRecentBook();
		}
		request.setAttribute("book", book);
		getPortletContext().getRequestDispatcher(
				response.encodeURL(Constants.PATH_TO_JSP_PAGE
						+ "recentBook.jsp")).include(request, response);
	}
}
