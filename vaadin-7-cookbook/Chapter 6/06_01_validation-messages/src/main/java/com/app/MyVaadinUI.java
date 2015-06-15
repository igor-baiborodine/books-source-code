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

        TextField txt = new TextField("Enter PIN Code");
        txt.addValidator(new PinValidator());
        txt.setImmediate(true);
        layout.addComponent(txt);
    }

}
