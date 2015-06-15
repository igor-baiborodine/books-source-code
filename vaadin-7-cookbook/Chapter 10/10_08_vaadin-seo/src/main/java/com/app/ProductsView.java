package com.app;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class ProductsView extends VerticalLayout implements View {

    public ProductsView() {
        Label lblHome = new Label("Products page");
        addComponent(lblHome);

        setMargin(true);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
