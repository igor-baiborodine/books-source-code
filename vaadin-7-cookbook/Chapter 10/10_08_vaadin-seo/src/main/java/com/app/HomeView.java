package com.app;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class HomeView extends VerticalLayout implements View {

    public HomeView() {
        Label lblHome = new Label("Home page");
        addComponent(lblHome);

        Button btnProducts = new Button("Go to products page");
        btnProducts.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                MyVaadinUI.getCurrent().getNavigator().navigateTo("products");
            }
        });
        addComponent(btnProducts);

        setMargin(true);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
