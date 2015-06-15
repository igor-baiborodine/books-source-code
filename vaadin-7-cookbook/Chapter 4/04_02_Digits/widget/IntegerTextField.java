package com.packtpub.vaadin.widget;

import com.packtpub.vaadin.widget.client.integertextfield.IntegerTextFieldState;

@SuppressWarnings("serial")
public class IntegerTextField extends com.vaadin.ui.TextField {

	@Override
	public IntegerTextFieldState getState() {
		return (IntegerTextFieldState) super.getState();
	}

	@Override
	public String getValue() {
		return getState().text;
	}

	@Override
	public void setValue(String value) {
		getState().text = value;
	}
}
