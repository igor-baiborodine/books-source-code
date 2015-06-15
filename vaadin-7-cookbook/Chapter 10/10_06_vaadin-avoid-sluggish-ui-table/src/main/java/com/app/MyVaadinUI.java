package com.app;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.*;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        Table table = new Table("Lazy loaded table");
        table.setWidth("200px");

        //table.setCacheRate(1);

        LazyLoadedContainer container = new LazyLoadedContainer(User.class);
        table.setContainerDataSource(container);
        layout.addComponent(table);
    }

}

class LazyLoadedContainer extends BeanContainer {

    private UserService userService = new UserService();

    public LazyLoadedContainer(Class type) {
        super(type);
    }

    @Override
    public int size() {
        return userService.size();
    }

    @Override
    public BeanItem getItem(Object itemId) {
        return new BeanItem((User) itemId);
    }

    @Override
    public List getItemIds(int startIndex, int numberOfIds) {
        int endIndex = startIndex + numberOfIds;
        System.out.println("startIndex: " + startIndex + ", endIndex: " + endIndex);
        List<User> list = userService.list(startIndex, endIndex);
        return list;
    }
}
