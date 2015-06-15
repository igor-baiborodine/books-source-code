package com.packtpub.vaadin.widget.client.tristatecheckbox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;
import com.packtpub.vaadin.widget.TriStateCheckbox;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@SuppressWarnings("serial")
@Connect(TriStateCheckbox.class)
public class TriStateCheckboxConnector extends AbstractComponentConnector {

	TriStateCheckboxServerRpc rpc = RpcProxy.create(
			TriStateCheckboxServerRpc.class, this);

	public TriStateCheckboxConnector() {

		getWidget().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {				
				rpc.valueChanged(getWidget().getValue());
			}
		});	
		
	}

	@Override
	protected Widget createWidget() {
		return GWT.create(TriStateCheckboxWidget.class);
	}

	@Override
	public TriStateCheckboxWidget getWidget() {
		return (TriStateCheckboxWidget) super.getWidget();
	}

	@Override
	public TriStateCheckboxState getState() {
		return (TriStateCheckboxState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
		getWidget().setText(getState().text);		
		getWidget().setValue(getState().checked);		
		getWidget().setIndeterminate(getState().indeterminate);		
	}

}
