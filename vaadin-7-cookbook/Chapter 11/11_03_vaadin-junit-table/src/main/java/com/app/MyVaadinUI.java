package com.app;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        TableLayout tableLayout = new TableLayout();
        tableLayout.init();
        setContent(tableLayout);
    }
}
