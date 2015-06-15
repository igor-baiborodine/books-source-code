package com.packtpub.vaadin;

import com.packtpub.vaadin.widget.ChromaHashPasswordField;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
public class Demo extends UI {

	@Override
	protected void init(VaadinRequest request) {
		setContent(new ChromaHashPasswordField());
	}

}