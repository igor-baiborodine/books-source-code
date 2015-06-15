package com;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * @author Ondrej Kvasnovsky
 */
public class HeaderLayout extends HorizontalLayout {

    public HeaderLayout() {
        Label label = new Label("User: John Felety");
        addComponent(label);
    }
}
