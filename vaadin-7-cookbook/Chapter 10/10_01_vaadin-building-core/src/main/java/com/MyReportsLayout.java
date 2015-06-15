package com;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class MyReportsLayout extends VerticalLayout {

    public MyReportsLayout() {
        Label lbl = new Label("My reports");
        addComponent(lbl);
    }
}
