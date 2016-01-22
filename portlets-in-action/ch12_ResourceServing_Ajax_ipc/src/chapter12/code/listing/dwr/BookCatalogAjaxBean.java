package chapter12.code.listing.dwr;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.directwebremoting.WebContextFactory;

import chapter12.code.listing.base.BookCatalogPortlet;
import chapter12.code.listing.domain.Book;
import chapter12.code.listing.service.BookService;
import chapter12.code.listing.utils.Message;

public class BookCatalogAjaxBean implements Serializable {
	private static final long serialVersionUID = -3664819092727825214L;
	private static Logger logger = Logger.getLogger(BookCatalogAjaxBean.class);
	private Properties props = new Properties();
	
	public BookCatalogAjaxBean() {
		InputStream inStream = this.getClass().getClassLoader()
				.getResourceAsStream("dwr.properties");
		try {
			props.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Message uploadToCFile(ToCFile tocFile, String isbnNumber, HttpServletRequest request)
			throws IOException, InterruptedException {
		Thread.sleep(4000); //--simulate slow connection
		logger.info("Uploading file - " + tocFile.getFileName());
		Message message = new Message();
		String fileExtension = tocFile.getFileName().substring(tocFile.getFileName().indexOf("."), 
				tocFile.getFileName().length());
		logger.info("File extension " + fileExtension);
		OutputStream outStream = new FileOutputStream(props.getProperty("uploadFolder")
				+ "\\"
				+ isbnNumber
				+ fileExtension);
		InputStream is = tocFile.getTocFile();
		byte[] buffer = new byte[1024];
		while (true) {
			int bytes = is.read(buffer);
			if (bytes <= 0) {
				break;
			}
			outStream.write(buffer, 0, bytes);
		}
		outStream.flush();
		BookService bookService = BookCatalogPortlet.getBookService();
		Book book = bookService.getBook(Long.valueOf(isbnNumber));
		book.setTocFileExtension(fileExtension);
		message.setResponseMessage("File successfully uploaded with name - " + isbnNumber + fileExtension);
		return message;
	}
	
	public String getObserverPortlet(HttpServletRequest request) {
		ServletContext ctx = request.getSession().getServletContext();
		String portlet = (String) ctx.getAttribute("recentlyAddedBookPortletNamespace");
		return portlet;
	}
	
	public Message addBook(Book book, HttpServletRequest request) throws InterruptedException {
		Thread.sleep(4000); //--simulate slow connection
		Message message = new Message();
		String name = book.getName();
		String author = book.getAuthor();
		String isbnNumber = String.valueOf(book.getIsbnNumber());
		
		logger.info("Book name: " + name + ", author : " + author
				+ ", ISBN number: " + isbnNumber);

		// --contains map of field names to error message
		Map<String, String> errorMap = new HashMap<String, String>();

		if (name == null || name.trim().equalsIgnoreCase("")) {
			errorMap.put("name", "Please enter book title");
		}
		if (author == null || author.trim().equalsIgnoreCase("")) {
			errorMap.put("author", "Please enter author name");
		}
		if (isbnNumber == null || isbnNumber.trim().equalsIgnoreCase("")) {
			errorMap.put("isbnNumber", "Please enter ISBN number");
		}
		if (isbnNumber == null || !StringUtils.isNumeric(isbnNumber)) {
			errorMap.put("isbnNumber", "Please enter a valid ISBN number");
		}

		// --if no error found, go ahead and save the book
		if (errorMap.isEmpty()) {
			logger.info("adding book to the data store");
			BookService bookService = BookCatalogPortlet.getBookService();
			bookService.addBook(new Book(name, author, Long
					.valueOf(isbnNumber)));
			message.setResponseMessage("Book successfully added to the catalog");
			message.setStatusCode("0");
		} else {
			logger
					.info("validation error occurred. re-showing the add book form");
			message.setResponseData(errorMap);
			message.setResponseMessage("Validation errors occurred while saving book details");
			message.setStatusCode("1");
		}
		return message;
	}
	
	public void startBookUpdateThread(String portletNamespace, HttpServletRequest request) {
		logger.info("Invoking startBookUpdateThread");
		ServletContext context = request.getSession(false).getServletContext();
		UpdateSender  updateSenderThread = UpdateSender.getInstance(context, portletNamespace);
		updateSenderThread.addScriptSession(WebContextFactory.get().getScriptSession());
	}
}
