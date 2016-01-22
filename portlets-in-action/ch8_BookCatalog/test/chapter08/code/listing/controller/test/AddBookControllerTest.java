package chapter08.code.listing.controller.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.portlet.RenderResponse;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.portlet.MockActionResponse;
import org.springframework.mock.web.portlet.MockRenderResponse;
import org.springframework.validation.BindException;
import org.springframework.web.bind.support.SimpleSessionStatus;

import chapter08.code.listing.controller.AddBookController;
import chapter08.code.listing.domain.Book;
import chapter08.code.listing.service.BookService;
/**
 * JUnit test for AddBookController.
 * @author asarin
 *
 */
public class AddBookControllerTest {
	private AddBookController addBookController;
	private BookService bookService = new MockBookService();

	@Before
	public void setUp() {
		addBookController = new AddBookController();
		addBookController.setBookService(bookService);
	}

	@Test
	public void testShowAddBookForm() {
		RenderResponse response = new MockRenderResponse();
		assertEquals("addBookForm", addBookController.showAddBookForm(response));
	}

	@Test
	public void testAddBook() {
		Book book = new Book("test book", "test author", 1234567890L);
		MockActionResponse response = new MockActionResponse();
		addBookController.addBook(book, new BindException(book, "book"),
				response, new SimpleSessionStatus());
		assertNotNull(bookService.getBook(1234567890L));
		assertEquals("books", response.getRenderParameter("myaction"));
	}
}