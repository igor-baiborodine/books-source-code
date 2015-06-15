package com.packtpub.vaadin.valid_field;

import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class EmailField extends TextField {
	
	public EmailField(String caption) {
		super(caption);		
		setImmediate(true);		
		addValidator(new EmailValidator("Invalid email"));			
	}

}
