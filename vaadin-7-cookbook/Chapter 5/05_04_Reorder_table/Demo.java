package com.packtpub.vaadin;

import com.packtpub.vaadin.reorder.ReorderTable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class Demo extends UI {
	@Override
	protected void init(VaadinRequest request) {		
		setContent(new ReorderTable());
	}
}