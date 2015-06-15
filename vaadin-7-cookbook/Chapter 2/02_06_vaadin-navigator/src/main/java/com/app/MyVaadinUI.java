package com.app;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        Navigator navigator = new Navigator(this, this);

        navigator.addView(WelcomeView.VIEW_NAME, new WelcomeView());
        navigator.addView(OrdersView.VIEW_NAME, OrdersView.class);

        navigator.navigateTo(WelcomeView.VIEW_NAME);
    }
}
