package com;

import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class PageLayout extends VerticalLayout {

    private HeaderLayout headerLayout;
    private BodyLayout bodyLayout;
    private FooterLayout footerLayout;

    public PageLayout() {
        setMargin(true);

        headerLayout = new HeaderLayout();
        addComponent(headerLayout);

        bodyLayout = new BodyLayout();
        addComponent(bodyLayout);

        footerLayout = new FooterLayout();
        addComponent(footerLayout);
    }

    public HeaderLayout getHeaderLayout() {
        return headerLayout;
    }

    public BodyLayout getBodyLayout() {
        return bodyLayout;
    }

    public FooterLayout getFooterLayout() {
        return footerLayout;
    }
}
