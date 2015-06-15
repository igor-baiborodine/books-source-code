package com.packtpub.vaadin;

import com.packtpub.vaadin.widget.TriStateCheckbox;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
public class Demo extends UI {

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setMargin(true);
		setContent(layout);

		final TriStateCheckbox triStateCheckbox = new TriStateCheckbox(
				"checkbox");

		Button indeterminateButton = new Button("set indeterminate");
		indeterminateButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				triStateCheckbox.setIndeterminate(!triStateCheckbox
						.isIndeterminate());
			}
		});

		layout.addComponent(triStateCheckbox);
		layout.addComponent(indeterminateButton);
	}

}