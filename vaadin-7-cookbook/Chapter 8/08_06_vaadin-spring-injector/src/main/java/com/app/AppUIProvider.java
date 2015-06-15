package com.app;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;

/**
 * Created with IntelliJ IDEA.
 * User: ondrej
 * Date: 19.03.13
 * Time: 23:02
 * To change this template use File | Settings | File Templates.
 */
public class AppUIProvider extends UIProvider {

    @Override
    public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
        return AppUI.class;
    }

    @Override
    public UI createInstance(UICreateEvent event) {
        UI instance = super.createInstance(event);
        Injector.inject(instance);
        return instance;
    }
}
