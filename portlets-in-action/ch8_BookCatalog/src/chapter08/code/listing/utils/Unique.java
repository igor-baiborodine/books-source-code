package chapter08.code.listing.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

import chapter08.code.listing.utils.MyUniqueConstraintValidator;

/**
 * Defines a custom Unique constraint annotation.
 * 
 * @author asarin
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=MyUniqueConstraintValidator.class)
public @interface Unique {
	String message() default "{unique.constraint.failure}";
	Class<?>[] groups() default {};
	public abstract Class<? extends Payload>[] payload() default {};
}