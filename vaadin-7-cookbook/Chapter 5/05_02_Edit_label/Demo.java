package com.packtpub.vaadin;

import com.packtpub.vaadin.editablelabel.EditableLabel;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class Demo extends UI {
	@Override
	protected void init(VaadinRequest request) {
		setContent(new EditableLabel("Vaadin 7"));				
	}
}
