package com.app.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class LoginView extends VerticalLayout implements View {

    public LoginView() {
        LoginForm loginForm = new LoginForm();
        addComponent(loginForm);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
