package chapter09.code.listing.base;

public class BookAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 4031346128258698247L;
	
	public BookAlreadyExistsException(String message) {
		super(message);
	}
}
