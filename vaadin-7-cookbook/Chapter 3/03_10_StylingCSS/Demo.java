package com.packtpub.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
@Theme("mytheme")
public class Demo extends UI {
	@Override
	protected void init(VaadinRequest request) {
		
		Table table = new Table();	
		table.setStyleName("myTable");
		table.addContainerProperty("First name", String.class, null);
		table.addContainerProperty("Second name", String.class, null);
		table.addItem(new Object[]{"Tom", "Smith"}, 0);
		table.addItem(new Object[]{"Bob", "Taylor"}, 1);
		table.addItem(new Object[]{"Jane", "White"}, 2);
		table.addItem(new Object[]{"Suzan", "Lee"}, 3);		
		table.setPageLength(table.size());		
		setContent(table);
	}
}