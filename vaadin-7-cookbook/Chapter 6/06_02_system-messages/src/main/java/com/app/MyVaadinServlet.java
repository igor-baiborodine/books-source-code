package com.app;

import com.vaadin.server.*;

import javax.servlet.ServletException;


public class MyVaadinServlet extends VaadinServlet {

    class MySessionInitListener implements SessionInitListener {

        public void sessionInit(SessionInitEvent e)
                throws ServiceException {
            VaadinService service = e.getService();
            MySystemMessagesProvider provider = new MySystemMessagesProvider();
            service.setSystemMessagesProvider(provider);
        }
    }

    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();

        VaadinServletService service = getService();
        MySessionInitListener listener = new MySessionInitListener();
        service.addSessionInitListener(listener);
    }
}
