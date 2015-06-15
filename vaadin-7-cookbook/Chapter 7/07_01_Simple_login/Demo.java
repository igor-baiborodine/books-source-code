package com.packtpub.vaadin;

import com.packtpub.vaadin.simple.LoginFormPanel;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Demo extends UI {
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		setContent(layout);
		
		LoginFormPanel loginPanel = new LoginFormPanel();
		layout.addComponent(loginPanel);
		layout.setSizeFull();
		
		layout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
	}
}
