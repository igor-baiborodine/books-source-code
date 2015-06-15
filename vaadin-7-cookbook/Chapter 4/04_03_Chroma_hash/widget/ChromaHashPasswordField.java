package com.packtpub.vaadin.widget;

import com.packtpub.vaadin.widget.client.chromahashpasswordfield.ChromaHashPasswordFieldState;

@SuppressWarnings("serial")
public class ChromaHashPasswordField extends com.vaadin.ui.PasswordField {

	@Override
	public ChromaHashPasswordFieldState getState() {
		return (ChromaHashPasswordFieldState) super.getState();
	}

	@Override
	public String getValue() {		
		return super.getValue();
	}

	@Override
	public void setValue(String value) {
		getState().text = value;
	}
}
