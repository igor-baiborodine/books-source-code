package chapter08.code.listing.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import chapter08.code.listing.domain.Book;

/**
 * Validator that is used by the EditBookController, for validating Book domain
 * object. The Validator has been used in the EditBookController because the Unique constraint
 * on the Book will always fail at the time of editing.
 * 
 * @author asarin
 *
 */
public class MyValidator implements Validator {

	public boolean supports(Class<?> klass) {
		return Book.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) {
		Book book = (Book)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.book.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "NotEmpty.book.author");
		String name = book.getName();
		if(name.length() >100 || name.length() < 10) {
			errors.rejectValue("name", "fieldLength");
		}
	}
}
