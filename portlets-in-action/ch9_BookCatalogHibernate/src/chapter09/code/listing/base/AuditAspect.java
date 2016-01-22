package chapter09.code.listing.base;

import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import chapter09.code.listing.domain.Book;

@Aspect
public class AuditAspect {

	@Before("execution(* chapter09.code.listing.service.BookService.addBook(..)) && args(book,..)")
	public void before(Book book) {
		if(book.getCreatedDate() == null) {
			book.setCreatedDate(new Date());
		} else {
			book.setModifiedDate(new Date());
		}
	}
}
