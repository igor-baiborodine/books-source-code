package com.packtpub.vaadin.widget.client.chromahashpasswordfield;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Widget;
import com.packtpub.vaadin.widget.ChromaHashPasswordField;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@SuppressWarnings("serial")
@Connect(ChromaHashPasswordField.class)
public class ChromaHashPasswordFieldConnector extends
		AbstractComponentConnector {

	public ChromaHashPasswordFieldConnector() {

		getWidget().addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {
				getWidget().updateChromaHashStripes();				
			}
		});

	}

	@Override
	protected Widget createWidget() {
		return GWT.create(ChromaHashPasswordFieldWidget.class);
	}

	@Override
	public ChromaHashPasswordFieldWidget getWidget() {
		return (ChromaHashPasswordFieldWidget) super.getWidget();
	}

	@Override
	public ChromaHashPasswordFieldState getState() {
		return (ChromaHashPasswordFieldState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
		final String text = getState().text;
		getWidget().setText(text);
		getWidget().updateChromaHashStripes();
	}

}
