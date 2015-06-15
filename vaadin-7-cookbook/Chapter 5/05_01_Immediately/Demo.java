package com.packtpub.vaadin;

import com.packtpub.vaadin.immediately.ImmediatelyTextArea;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class Demo extends UI {
	@Override
	protected void init(VaadinRequest request) {
		setContent(new ImmediatelyTextArea());
	}
}