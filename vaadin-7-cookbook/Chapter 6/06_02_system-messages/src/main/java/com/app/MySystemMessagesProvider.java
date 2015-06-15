package com.app;

import com.vaadin.server.CustomizedSystemMessages;
import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;

/**
 * @author Ondrej Kvasnovsky
 */
public class MySystemMessagesProvider implements SystemMessagesProvider {

    @Override
    public SystemMessages getSystemMessages(SystemMessagesInfo systemMessagesInfo) {
        CustomizedSystemMessages messages = new CustomizedSystemMessages();
        messages.setCommunicationErrorCaption("The server is down");
        messages.setInternalErrorCaption("Internal error");
        messages.setSessionExpiredCaption("Session has expired");
        messages.setOutOfSyncCaption("Out of synchronization");
        messages.setCookiesDisabledCaption("Cookies disabled");
        messages.setAuthenticationErrorCaption("Authentication error");
        return messages;
    }
}
