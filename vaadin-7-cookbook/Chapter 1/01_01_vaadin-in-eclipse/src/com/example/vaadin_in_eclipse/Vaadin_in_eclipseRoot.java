package com.example.vaadin_in_eclipse;

import com.vaadin.ui.*;
import com.vaadin.terminal.WrappedRequest;

public class Vaadin_in_eclipseRoot extends Root {
	@Override
	public void init(WrappedRequest request) {
		String user = System.getProperty("user.name");
		Label label = new Label("Hello Vaadin user: " + user);
		addComponent(label);
	}

}
