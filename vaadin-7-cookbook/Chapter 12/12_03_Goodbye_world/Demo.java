package com.packtpub.vaadin;

import com.packtpub.vaadin.close.GoodbyeWorld;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Demo extends UI {
	
	@Override
	public void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();		
		setContent(layout);
		layout.addComponent(new Label("Vaadin application"));
		layout.addComponent(new GoodbyeWorld());
	}

}
