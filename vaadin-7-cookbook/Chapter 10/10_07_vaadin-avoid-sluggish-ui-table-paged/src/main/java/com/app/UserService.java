package com.app;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ondrej Kvasnovsky
 */
public class UserService {

    private List<User> dbFake = new ArrayList<User>();

    public UserService() {
        for (int i = 0; i < 1000; i++) {
            dbFake.add(new User("Sara " + i++));
            dbFake.add(new User("Nicolas " + i++));
            dbFake.add(new User("Matthew " + i++));
            dbFake.add(new User("Michaela " + i++));
            dbFake.add(new User("Martin " + i++));
            dbFake.add(new User("Anna " + i++));
            dbFake.add(new User("Ester " + i++));
        }
    }

    public int size() {
        return dbFake.size();
    }

    public List<User> list(int startIndex, int endIndex) {
        List<User> users = dbFake.subList(startIndex, endIndex);
        return users;
    }
}
