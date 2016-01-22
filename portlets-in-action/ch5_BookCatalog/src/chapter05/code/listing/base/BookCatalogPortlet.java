package chapter05.code.listing.base;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.MimeResponse;
import javax.portlet.PortalContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.apache.log4j.Logger;
import org.w3c.dom.Element;

import chapter05.code.listing.domain.Book;
import chapter05.code.listing.utils.BookDataObject;
import chapter05.code.listing.utils.Constants;

public class BookCatalogPortlet extends GenericPortlet {
	private Logger logger = Logger.getLogger(BookCatalogPortlet.class);

	protected void doHeaders(RenderRequest request, RenderResponse response) {
		super.doHeaders(request, response);
		PortalContext portalContext = request.getPortalContext();
		String portalInfo = portalContext.getPortalInfo();

		// -- adding DOM element to head is supported by JetSpeed 2.2
		if (portalInfo.contains(Constants.JETSPEED)) {
			// -- add CSS
			Element cssElement = response.createElement("link");
			// --encoding URLs is important
			cssElement.setAttribute("href", response.encodeURL((request
					.getContextPath() + "/css/bookCatalog.css")));
			cssElement.setAttribute("rel", "stylesheet");
			cssElement.setAttribute("type", "text/css");
			response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, cssElement);

			// -- add JavaScript
			Element jsElement = response.createElement("script");

			// --encoding URLs to resources is important
			jsElement.setAttribute("src", response.encodeURL((request
					.getContextPath() + "/js/bookCatalog.js")));
			jsElement.setAttribute("type", "text/javascript");
			response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, jsElement);
		}
	}

	@RenderMode(name = "print")
	public void showPrint(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		request.setAttribute("myaction", "print");
		logger.info("Generating printable version of catalog");
		showPrintableCatalog(request, response);
	}

	@RenderMode(name = "help")
	public void showHelp(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		logger.info("Generating Help information for the portlet");
		showHelpInfo(request, response);
	}

	@RenderMode(name = "edit")
	public void showPrefs(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		logger.info("Generating Preferences details for the portlet");
		showPrefsInfo(request, response);
	}

	@SuppressWarnings("unchecked")
	@RenderMode(name = "VIEW")
	public void showBooks(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		logger.info("Entering showBooks method");
		PortalContext context = request.getPortalContext();
		printSupportedPortletModes(context);
		printSupportedWindowStates(context);

		// --get user attributes user.name.given and user.name.family
		Map<String, Object> userAttributeMap = (Map<String, Object>) request
				.getAttribute(PortletRequest.USER_INFO);
		String firstName = "";
		String lastName = "";
		if (userAttributeMap != null) {
			firstName = (String) userAttributeMap.get("user.name.given");
			lastName = (String) userAttributeMap.get("user.name.family");
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
		}

		String portalInfo = context.getPortalInfo();
		request.setAttribute("portalInfo", portalInfo);

		// --generate all the URLs that will be used by the portlet
		generateUrls(request, response);

		String myaction = request.getParameter("myaction");
		if (myaction != null) {
			logger.info("myaction parameter is not null. Value is " + myaction);
			request.getPortletSession().setAttribute("myaction", myaction,
					PortletSession.PORTLET_SCOPE);
		} else {
			// -- if myaction is NULL then show the home page of Book
			// catalog
			// page
			request.getPortletSession().setAttribute("myaction", "showCatalog",
					PortletSession.PORTLET_SCOPE);
		}

		// -- send myaction as a request attribute to the BookServlet.
		request.setAttribute("myaction", request.getPortletSession()
				.getAttribute("myaction"));

		// --dynamically obtain the title for the portlet, based on myaction
		String titleKey = "portlet.title."
				+ (String) request.getPortletSession().getAttribute("myaction");
		response.setTitle(getResourceBundle(request.getLocale()).getString(
				titleKey));

		// --if the action is uploadTocForm then store the ISBN number of
		// the
		// --book for which the TOC is being uploaded. The upload action
		// will use the ISBN number to create file name -- refer home.jsp
		// page
		if (((String) request.getAttribute("myaction"))
				.equalsIgnoreCase("uploadTocForm")) {
			request.getPortletSession().setAttribute("isbnNumber",
					request.getParameter("isbnNumber"));
		}

		if (((String) request.getPortletSession().getAttribute("myaction"))
				.equalsIgnoreCase("showSearchResults")) {
			request.setAttribute("matchingBooks", request.getPortletSession()
					.getAttribute("matchingBooks"));
		}

		// its important to encode URLs
		PortletRequestDispatcher dispatcher = request.getPortletSession()
				.getPortletContext().getRequestDispatcher(
						response.encodeURL("/myservlet/bookServlet"));
		dispatcher.include(request, response);
	}

	@ProcessAction(name = "removeBookAction")
	public void removeBook(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		logger.info("Inside removeBook action method");
		if (!request.isUserInRole("administrator")) {
			response.setRenderParameter("myaction", "error");
			response.setRenderParameter("exceptionMsg",
					"You are not authorized for this action. You must have Administrator role.");
			return;
		}
		request.setAttribute("myaction", "removeBookAction");
		PortletRequestDispatcher dispatcher = request.getPortletSession()
				.getPortletContext().getRequestDispatcher(
						response.encodeURL("/myservlet/bookServlet"));
		dispatcher.include(request, response);
		response.setRenderParameter("myaction", "showCatalog");
	}

	@ProcessAction(name = "uploadTocAction")
	public void uploadToc(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		logger.info("Inside uploadToc action method");
		if (!request.isUserInRole("administrator")) {
			response.setRenderParameter("myaction", "error");
			response.setRenderParameter("exceptionMsg",
					"You are not authorized for this action. You must have Administrator role.");
			return;
		}

		String isbnNumber = (String) request.getPortletSession().getAttribute(
				"isbnNumber");
		logger.info("ISBN Number of selected book : " + isbnNumber);

		// --obtain the Book catalog from PortletContext
		BookDataObject catalog = (BookDataObject) getPortletContext()
				.getAttribute("bookCatalog");
		// --get the Book with the same ISBN number
		Book matchingBook = null;
		List<Book> books = catalog.getBooks();
		for (Book book : books) {
			if (book.getIsbnNumber().longValue() == Long.valueOf(isbnNumber)) {
				matchingBook = book;
				break;
			}
		}
		if (matchingBook != null) {
			logger.info("Setting download URL for book with ISBN "
					+ matchingBook.getIsbnNumber() + " to "
					+ request.getParameter("tocDownloadUrl"));
			matchingBook.setDownloadUrl(request.getParameter("tocDownloadUrl"));
		} else {
			response.setRenderParameter("myaction", "error");
			response.setRenderParameter("exceptionMsg",
					"No matching book with ISBN number " + isbnNumber
							+ " found in the catalog");
		}
	}

	@ProcessAction(name = "resetAction")
	public void resetAction(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		logger.info("Inside reset action");
		response.setRenderParameter("myaction", "showCatalog");
	}

	@ProcessAction(name = "searchBookAction")
	public void searchBook(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		logger.info("Inside search Book action");
		request.setAttribute("myaction", "searchBookAction");
		PortletRequestDispatcher dispatcher = request.getPortletSession()
				.getPortletContext().getRequestDispatcher(
						response.encodeURL("/myservlet/bookServlet"));
		dispatcher.include(request, response);
		response.setRenderParameter("myaction", "showSearchResults");

		// --store the search criteria in session
		request.getPortletSession().setAttribute("authorNameSearchField",
				request.getParameter("authorNameSearchField"),
				PortletSession.APPLICATION_SCOPE);
		request.getPortletSession().setAttribute("bookNameSearchField",
				request.getParameter("bookNameSearchField"),
				PortletSession.APPLICATION_SCOPE);
		// retrieving the matchingBooks request attribute set by BookServlet and
		// store it in session
		request.getPortletSession().setAttribute("matchingBooks",
				request.getAttribute("matchingBooks"));
	}

	@SuppressWarnings("unchecked")
	@ProcessAction(name = "addBookAction")
	public void addBook(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		logger.info("addBook action invoked");
		if (!request.isUserInRole("administrator")) {
			response.setRenderParameter("myaction", "error");
			response.setRenderParameter("exceptionMsg",
					"You are not authorized for this action. You must have Administrator role.");
			return;
		}
		request.setAttribute("myaction", "addBookAction");
		PortletRequestDispatcher dispatcher = request.getPortletSession()
				.getPortletContext().getRequestDispatcher(
						response.encodeURL("/myservlet/bookServlet"));
		dispatcher.include(request, response);
		Map<String, String> map = (Map<String, String>) request.getAttribute("errors");
		if (map != null && !map.isEmpty()) {
			response.setRenderParameter("myaction", "addBookAction");
		} else {
			response.setRenderParameter("myaction", "showCatalog");
		}
	}

	private void generateUrls(RenderRequest request, RenderResponse response)
			throws PortletModeException, WindowStateException {
		// Render URL for Print hyperlink
		PortletURL printModeUrl = response.createRenderURL();
		if (request.isPortletModeAllowed(new PortletMode("print"))) {
			printModeUrl.setPortletMode(new PortletMode("print"));
		}
		if (request.isWindowStateAllowed(new WindowState("pop_up"))) {
			printModeUrl.setWindowState(new WindowState("pop_up"));
		}
		request.setAttribute("printModeUrl", printModeUrl);

		// Action URL for upload Toc action
		PortletURL uploadTocActionUrl = response.createActionURL();
		uploadTocActionUrl.setParameter("myaction", "uploadTocAction");
		uploadTocActionUrl.setParameter(ActionRequest.ACTION_NAME,
				"uploadTocAction");
		request.setAttribute("uploadTocActionUrl", uploadTocActionUrl);

		// Render URL for Full Screen hyperlink
		PortletURL fullScreenUrl = response.createRenderURL();
		fullScreenUrl.setWindowState(WindowState.MAXIMIZED);
		request.setAttribute("fullScreenUrl", fullScreenUrl);

		// Render URL for Help hyperlink
		PortletURL helpUrl = response.createRenderURL();
		helpUrl.setPortletMode(PortletMode.HELP);
		request.setAttribute("helpUrl", helpUrl);

		// Render URL for Home hyperlink
		PortletURL homeUrl = response.createRenderURL();
		homeUrl.setPortletMode(PortletMode.VIEW);
		request.setAttribute("homeUrl", homeUrl);

		// Render URL for Preferences hyperlink
		PortletURL prefUrl = response.createRenderURL();
		prefUrl.setPortletMode(PortletMode.EDIT);
		request.setAttribute("prefUrl", prefUrl);

		// Render URL for form submission for Adding book
		PortletURL addBookFormUrl = response.createRenderURL();
		addBookFormUrl.setParameter("myaction", "addBookForm");
		request.setAttribute("addBookFormUrl", addBookFormUrl);

		// Action URL for Add Book Action
		PortletURL addBookActionUrl = response.createActionURL();
		addBookActionUrl.setParameter(ActionRequest.ACTION_NAME,
				"addBookAction");
		request.setAttribute("addBookActionUrl", addBookActionUrl);

		// Action URL for resetting search
		PortletURL resetActionUrl = response.createActionURL();
		resetActionUrl.setParameter(ActionRequest.ACTION_NAME, "resetAction");
		request.setAttribute("resetActionUrl", resetActionUrl);

		// Action URL for searching books
		PortletURL searchBookActionUrl = response.createActionURL();
		searchBookActionUrl.setParameter(ActionRequest.ACTION_NAME,
				"searchBookAction");
		request.setAttribute("searchBookActionUrl", searchBookActionUrl);

		// Render URL for Refresh Search Results link
		PortletURL refreshResultsUrl = response.createRenderURL();
		refreshResultsUrl.setParameter("myaction", "refreshResults");
		request.setAttribute("refreshResultsUrl", refreshResultsUrl);
	}

	private void printSupportedPortletModes(PortalContext context) {
		// -- supported portlet modes by the portal server
		Enumeration<PortletMode> portletModes = context
				.getSupportedPortletModes();
		while (portletModes.hasMoreElements()) {
			PortletMode mode = portletModes.nextElement();
			logger.info("Support portlet mode " + mode.toString());
		}
	}

	private void printSupportedWindowStates(PortalContext context) {
		// -- supported window states by the portal server
		Enumeration<WindowState> windowStates = context
				.getSupportedWindowStates();
		while (windowStates.hasMoreElements()) {
			WindowState windowState = windowStates.nextElement();
			logger.info("Support window state " + windowState.toString());
		}
	}

	private void showHelpInfo(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletRequestDispatcher dispatcher = request.getPortletSession()
				.getPortletContext().getRequestDispatcher(
						response.encodeURL("/WEB-INF/jsp/help.jsp"));
		dispatcher.include(request, response);
	}

	private void showPrefsInfo(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletRequestDispatcher dispatcher = request.getPortletSession()
				.getPortletContext().getRequestDispatcher(
						response.encodeURL("/WEB-INF/jsp/preferences.jsp"));
		dispatcher.include(request, response);
	}

	private void showPrintableCatalog(RenderRequest request,
			RenderResponse response) throws PortletException, IOException {
		PortletRequestDispatcher dispatcher = request.getPortletSession()
				.getPortletContext().getRequestDispatcher(
						response.encodeURL("/myservlet/bookServlet"));
		dispatcher.include(request, response);
	}
}
