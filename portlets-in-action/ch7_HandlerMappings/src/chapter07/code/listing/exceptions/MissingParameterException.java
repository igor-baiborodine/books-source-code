package chapter07.code.listing.exceptions;

/**
 * Exception thrown when an expected parameter is found missing from the
 * request.
 * @author asarin
 *
 */
public class MissingParameterException extends RuntimeException {

	private static final long serialVersionUID = -8274001065024413529L;
	
	public MissingParameterException(String message) {
		super(message);
	}
	
}
