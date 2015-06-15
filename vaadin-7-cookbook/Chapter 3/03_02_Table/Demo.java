package com.packtpub.vaadin;

import com.packtpub.vaadin.table.PriceList;
import com.packtpub.vaadin.table.Product;
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
		PriceList priceList = new PriceList(createProductContainer());
		setContent(priceList);
	}
	
	private BeanItemContainer<Product> createProductContainer() {
		BeanItemContainer<Product> container = new BeanItemContainer<Product>(Product.class);
		container.addItem(new Product("Computer", 599.90));
		container.addItem(new Product("Mobile phone", 14.5));
		container.addItem(new Product("Tablet", 99.90));
		container.addItem(new Product("Mouse", 0.99));	
		return container;
	}
	
}