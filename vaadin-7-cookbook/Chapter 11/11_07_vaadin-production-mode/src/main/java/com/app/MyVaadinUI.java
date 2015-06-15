package com.app;

import com.vaadin.server.DeploymentConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @Override
    protected void init(VaadinRequest request) {

        VaadinService service = request.getService();
        DeploymentConfiguration deploymentConfiguration = service.getDeploymentConfiguration();
        boolean productionMode = deploymentConfiguration.isProductionMode();
        if (productionMode) {
            ProductionErrorHandler errorHandler = new ProductionErrorHandler();
            setErrorHandler(errorHandler);
        }

        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        Button button = new Button("Throw an error please");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Click and bang!"));
                throw new RuntimeException("I am the runtime exception and I shouldn't be shown to the clients.");
            }
        });

        layout.addComponent(button);
    }

}
