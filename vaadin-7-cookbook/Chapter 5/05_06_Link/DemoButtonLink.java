package com.packtpub.vaadin;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class DemoButtonLink extends UI {
	
	@Override
	public void init(VaadinRequest request) {
		Button button = new Button("Vaadin");
		button.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getPage().open("http://vaadin.com", "Vaadin");
			}
		});
		button.setStyleName(Reindeer.BUTTON_LINK);
		setContent(button);
	}
	
}
