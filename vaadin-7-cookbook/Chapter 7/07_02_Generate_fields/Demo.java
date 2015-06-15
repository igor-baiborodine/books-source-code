package com.packtpub.vaadin;

import com.packtpub.vaadin.generate.GeneratedProductForm;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class Demo extends UI {

	@Override
	protected void init(VaadinRequest request) {
		GeneratedProductForm productForm = new GeneratedProductForm();				
		addComponent(productForm);
	}

}
