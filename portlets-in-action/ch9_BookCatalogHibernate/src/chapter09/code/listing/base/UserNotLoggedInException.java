package chapter09.code.listing.base;

public class UserNotLoggedInException extends Exception {

	private static final long serialVersionUID = 1098202671174689221L;
	
	public UserNotLoggedInException(String message) {
		super(message);
	}
}
