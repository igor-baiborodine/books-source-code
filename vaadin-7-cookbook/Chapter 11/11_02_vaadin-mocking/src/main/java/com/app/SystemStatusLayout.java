package com.app;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class SystemStatusLayout extends HorizontalLayout {

    private Label lblSystemStatus;

    public SystemStatusLayout() {
        String value = SystemStatusService.getValue();
        lblSystemStatus = new Label(value);
        addComponent(lblSystemStatus);
    }

    public Label getLblSystemStatus() {
        return lblSystemStatus;
    }
}
