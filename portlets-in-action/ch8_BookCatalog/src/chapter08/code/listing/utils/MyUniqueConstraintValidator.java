package chapter08.code.listing.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import chapter08.code.listing.service.BookService;

/**
 * Validator for the Unique constraint annotation.
 * 
 * @author asarin
 *
 */
public class MyUniqueConstraintValidator implements ConstraintValidator<Unique, Long> {
	@Autowired
	@Qualifier("myBookService")
	private BookService bookService;
	
	public void initialize(Unique annotation) {
		//-- do nothing
	}

	public boolean isValid(Long isbnNumber, ConstraintValidatorContext context) {
		return bookService.isUniqueISBN(isbnNumber);
	}
}
