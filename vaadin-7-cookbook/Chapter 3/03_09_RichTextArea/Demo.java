package com.packtpub.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.UI;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
@Theme("mytheme")
public class Demo extends UI {
	@Override
	protected void init(VaadinRequest request) {
		
		RichTextArea richTextArea = new RichTextArea();
		richTextArea.setStyleName("my");		
		setContent(richTextArea);
	}
}