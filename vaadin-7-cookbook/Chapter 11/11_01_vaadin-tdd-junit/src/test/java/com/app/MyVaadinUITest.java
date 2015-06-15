package com.app;

import com.vaadin.ui.Component;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyVaadinUITest {

    private MyVaadinUI ui;

    @Before
    public void setUp() {
        ui = new MyVaadinUI();
        ui.init(null);
    }

    @Test
    public void isContentLoginLayout() throws Exception {
        Component content = ui.getContent();
        Assert.assertTrue(content instanceof LoginLayout);
    }
}
