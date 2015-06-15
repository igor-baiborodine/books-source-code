package com.app;

/**
 * @author Ondrej Kvasnovsky
 */
public class UserService {

    public User getUser() {
        // TODO: here we could fetch data from e.g. database
        User user = new User();
        user.setName("Adela");
        return user;
    }
}
