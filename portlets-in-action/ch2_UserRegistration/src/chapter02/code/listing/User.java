package chapter02.code.listing;

import java.io.Serializable;

/**
 * User bean which holds the registration information.
 * 
 * @author asarin
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 5972069510459564412L;
	private String firstName;
	private String lastName;
	private String email;
	
	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
}
