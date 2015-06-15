package com.app;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ondrej Kvasnovsky
 */
public class MyVaadinUITest {

    private MyVaadinUI ui;

    @Before
    public void setUp() {
        ui = new MyVaadinUI();
        ui.init(null);
    }

    @Test
    public void isContentInstanceOfPageLayout() throws Exception {
        Assert.assertTrue(ui.getContent() instanceof TableLayout);
    }
}
