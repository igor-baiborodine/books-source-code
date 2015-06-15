package com.packtpub.vaadin;

import com.packtpub.vaadin.list.Contact;
import com.packtpub.vaadin.list.ContactViewer;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
public class Demo extends UI {

	@Override
	protected void init(VaadinRequest request) {
		ContactViewer contactViewer = new ContactViewer(createContactContainer());
		setContent(contactViewer);
	}

	private BeanItemContainer<Contact> createContactContainer() {
		BeanItemContainer<Contact> contacts = new BeanItemContainer<>(Contact.class);
		contacts.addItem(new Contact("Tom", "Smith", "tom.smith@gmail.com"));
		contacts.addItem(new Contact("Bob", "Taylor", "bob.taylor@yahoo.com"));
		contacts.addItem(new Contact("Jane", "White", "jane.white@outlook.com"));
		contacts.addItem(new Contact("Suzan", "Lee", "suzan.lee@aol.com"));
		return contacts;
	}

}