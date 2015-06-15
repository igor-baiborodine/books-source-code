package com;

import com.google.gwt.core.ext.typeinfo.JClassType;
import com.vaadin.server.widgetsetutils.ConnectorBundleLoaderFactory;
import com.vaadin.shared.ui.Connect;
import com.vaadin.ui.*;

import java.util.*;

public class OptimizedConnectorBundleLoaderFactory extends
        ConnectorBundleLoaderFactory {
    private Set<String> eagerConnectors = new HashSet<String>();

    {
        eagerConnectors.add(com.vaadin.client.ui.orderedlayout.VerticalLayoutConnector.class.getName());
        eagerConnectors.add(com.vaadin.client.ui.button.ButtonConnector.class.getName());
        eagerConnectors.add(com.vaadin.client.ui.ui.UIConnector.class.getName());
    }

    @Override
    protected Connect.LoadStyle getLoadStyle(JClassType connectorType) {
        if (eagerConnectors.contains(connectorType.getQualifiedBinaryName())) {
            return Connect.LoadStyle.EAGER;
        } else {
            // Loads all other connectors immediately after the initial view has
            // been rendered
            return Connect.LoadStyle.DEFERRED;
        }
    }
}