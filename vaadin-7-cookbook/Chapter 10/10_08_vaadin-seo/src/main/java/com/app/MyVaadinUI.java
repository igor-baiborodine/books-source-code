package com.app;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * The Application's "main" class
 */
@PreserveOnRefresh
public class MyVaadinUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        Navigator navigator = new Navigator(this, this);
        navigator.addView("", HomeView.class);
        navigator.addView("home", HomeView.class);
        navigator.addView("products", ProductsView.class);
    }
}
