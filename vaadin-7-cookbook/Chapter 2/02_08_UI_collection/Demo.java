package com.packtpub.vaadin;

import com.packtpub.vaadin.accordion.ComponentCollection;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class Demo extends UI {
	@Override
	public void init(VaadinRequest request) {		
		HorizontalSplitPanel horSplitPanel = new HorizontalSplitPanel();		
		horSplitPanel.setSplitPosition(20, Unit.PERCENTAGE);
		horSplitPanel.setFirstComponent(new ComponentCollection());	
		setContent(horSplitPanel);	
	}
}
