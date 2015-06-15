package com.app.ui;

import com.app.bean.MyBean;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.server.WrappedHttpSession;
import com.vaadin.server.WrappedRequest;
import com.vaadin.server.WrappedSession;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * The Application's "main" class
 */
@PreserveOnRefresh
public class AppUI extends UI {

    @Override
    protected void init(WrappedRequest request) {
        WrappedSession session = request.getWrappedSession();
        HttpSession httpSession = ((WrappedHttpSession) session).getHttpSession();
        ServletContext servletContext = httpSession.getServletContext();
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        MyBean bean = applicationContext.getBean(MyBean.class);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            addComponent(new Label(bean.getAuthenticated()));
        } else {
            addComponent(new Label(bean.getNotAuthenticated()));
        }
    }
}
