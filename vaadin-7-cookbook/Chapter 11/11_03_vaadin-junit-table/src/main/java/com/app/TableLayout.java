package com.app;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.*;

import java.util.List;

/**
 * @author Ondrej Kvasnovsky
 */
public class TableLayout extends VerticalLayout {

    private Table table = new Table();
    private UserService userService = new UserService();

    public void init() {
        setMargin(true);

        BeanItemContainer<User> container = getContainer();
        table.setContainerDataSource(container);

        addComponent(table);
    }

    public Table getTable() {
        return table;
    }

    // container that is connected to the database, we need to avoid the connection to database in unit tests
    BeanItemContainer<User> getContainer() {
        BeanItemContainer<User> container = new BeanItemContainer<User>(User.class);

        List<User> all = userService.findAll();
        for (User user : all) {
            container.addBean(user);
        }
        return container;
    }

    void setUserService(UserService service) {
        this.userService = service;
    }
}
