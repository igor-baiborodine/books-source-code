package chapter11.code.listing.base;

import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import chapter11.code.listing.events.BookAddedEvent;
import chapter11.code.listing.utils.Constants;

public class RecentlyAddedBookPortlet extends GenericPortlet {
	private Logger logger = Logger.getLogger(RecentlyAddedBookPortlet.class);
	
	@RenderMode(name="view")
	public void showLatestBook(RenderRequest request, RenderResponse response)
	throws IOException, PortletException {
		logger.info("Entering showLatestBook render method");
		getPortletContext().getRequestDispatcher(
				response.encodeURL(Constants.PATH_TO_JSP_PAGE
						+ "recentPortletHome.jsp")).include(request, response);
	}
	
	@ProcessEvent(qname="{http://www.mynamespace.com}bookAddedEvent")
	public void processAddedBookEvent(EventRequest request, EventResponse eventResponse)
		throws IOException, PortletException {
		logger.info("Processing bookAddedEvent.....");
		Event event = request.getEvent();
		BookAddedEvent bookAddedEvent = (BookAddedEvent)event.getValue();
		eventResponse.setRenderParameter("category", bookAddedEvent.getCategory());
		eventResponse.setRenderParameter("name", bookAddedEvent.getName());
		eventResponse.setRenderParameter("author", bookAddedEvent.getAuthor());
		eventResponse.setRenderParameter("isbnNumber", String.valueOf(bookAddedEvent.getIsbnNumber()));
	}
}