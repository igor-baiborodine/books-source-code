package com.app.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Ondrej Kvasnovsky
 */
public class LogoutListener implements Button.ClickListener {

    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {
        SecurityContextHolder.clearContext();
        UI.getCurrent().close();
        Navigator navigator = UI.getCurrent().getNavigator();
        navigator.navigateTo("login");
    }
}
