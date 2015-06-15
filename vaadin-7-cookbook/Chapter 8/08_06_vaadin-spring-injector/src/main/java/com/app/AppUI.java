package com.app;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class AppUI extends UI {

    @Autowired
    UserService userService;

    @Override
    protected void init(VaadinRequest request) {
        //Injector.inject(this);
//        VerticalLayout layout = new VerticalLayout();
//        layout.setMargin(true);
//        setContent(layout);

        String name = userService.getUser().getName();
        Label lblUserName = new Label("Hi " + name + " !");
        setContent(lblUserName);
    }
}
