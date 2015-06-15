package com.app;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

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

        VerticalLayout login = new VerticalLayout();
        TextField txtUsername = new TextField("Username:");
        login.addComponent(txtUsername);
        TextField txtPassword = new TextField("Password:");
        login.addComponent(txtPassword);
        Button btnLogin = new Button("Login");
        login.addComponent(btnLogin);

        PopupView popup = new PopupView("Click me!", login);
//        popup.setHideOnMouseOut(true);
        layout.addComponent(popup);
    }
}
