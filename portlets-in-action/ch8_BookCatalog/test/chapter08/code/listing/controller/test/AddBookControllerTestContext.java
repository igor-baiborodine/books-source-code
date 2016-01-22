package chapter08.code.listing.controller.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import javax.portlet.RenderResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mock.web.portlet.MockActionResponse;
import org.springframework.mock.web.portlet.MockRenderResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.validation.BindException;
import org.springframework.web.bind.support.SimpleSessionStatus;

import chapter08.code.listing.controller.AddBookController;
import chapter08.code.listing.domain.Book;
import chapter08.code.listing.service.BookService;
/** 
 * TestContext class responsible for testing the portlet. The class has been written to test
 * the handler methods of the AddBookController and the Book domain object, to demonstrate
 * the use of TestContext framework to perform Unit Testing.
 *
 * @author asarin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:bookCatalogTest-portlet.xml")
@TestExecutionListeners(value = { DependencyInjectionTestExecutionListener.class })
public class AddBookControllerTestContext extends AbstractJUnit4SpringContextTests{
	@Autowired
	@Qualifier("addBookController")
	private AddBookController addBookController;
	
	@Autowired
	@Qualifier("myBookService")
	private BookService bookService;
	
	@Autowired
    private Validator validator;
    
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
	
	@Test 
	public void testBook() {
		Book book = new Book();
		book.setName("Book Name"); //--should result in error because size is < 10
		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		//-- 3 errors should be reported. 1) the author field is empty
		//-- 2) the Book name is less than 10 characters
		//-- 3) The ISBN number wasn't specified which should result in Unique constraint failure
		int[] actual = {violations.size()};
		int[] expected = {3};
	    assertArrayEquals(expected, actual);
	}
}
