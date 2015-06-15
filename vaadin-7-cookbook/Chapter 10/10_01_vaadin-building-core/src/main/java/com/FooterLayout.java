package com;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * @author Ondrej Kvasnovsky
 */
public class FooterLayout extends HorizontalLayout {

    public FooterLayout() {
        Label label = new Label("Created by me.");
        addComponent(label);
    }
}
