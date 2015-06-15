package com;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    private PageLayout pageLayout;

    @Override
    protected void init(VaadinRequest request) {
        pageLayout = new PageLayout();
        setContent(pageLayout);
    }

    public PageLayout getPageLayout() {
        return pageLayout;
    }

    public static MyVaadinUI getCurrent() {
        return (MyVaadinUI) UI.getCurrent();
    }
}
