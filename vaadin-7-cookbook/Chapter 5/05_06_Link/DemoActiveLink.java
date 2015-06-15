package com.packtpub.vaadin;

import org.vaadin.activelink.ActiveLink;
import org.vaadin.activelink.ActiveLink.LinkActivatedEvent;
import org.vaadin.activelink.ActiveLink.LinkActivatedListener;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class DemoActiveLink extends UI {
	
	@Override
	public void init(VaadinRequest request) {
		ActiveLink link = new ActiveLink("Vaadin", new ExternalResource(
				"http://vaadin.com"));
		link.setTargetName("_blank");
		link.addListener(new LinkActivatedListener() {
			public void linkActivated(LinkActivatedEvent event) {
				Notification.show("Link was opened in a new window.");
			}
		});

		setContent(link);
	}
}
