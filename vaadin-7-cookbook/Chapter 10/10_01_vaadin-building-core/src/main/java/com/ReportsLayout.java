package com;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class ReportsLayout extends VerticalLayout {

    public ReportsLayout() {
        Label lbl = new Label("Reports");
        addComponent(lbl);
    }
}
