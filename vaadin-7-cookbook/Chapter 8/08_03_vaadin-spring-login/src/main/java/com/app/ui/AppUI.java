package com.app.ui;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.WrappedHttpSession;
import com.vaadin.server.WrappedSession;
import com.vaadin.ui.UI;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * The Application's "main" class
 */
@PreserveOnRefresh
public class AppUI extends UI {

    private ApplicationContext applicationContext;

    @Override
    protected void init(VaadinRequest request) {
        WrappedSession session = request.getWrappedSession();
        HttpSession httpSession = ((WrappedHttpSession) session).getHttpSession();
        ServletContext servletContext = httpSession.getServletContext();
        applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        Navigator navigator = new Navigator(this, this);

        navigator.addView("login", LoginView.class);

        navigator.addView("user", UserView.class);

        navigator.navigateTo("login");
        setNavigator(navigator);
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
