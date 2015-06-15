package com.packtpub.vaadin;

import com.packtpub.vaadin.adjust.AdjustableLayout;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class Demo extends UI {
	@Override
	public void init(VaadinRequest request) {
		setContent(new AdjustableLayout());
	}
}
