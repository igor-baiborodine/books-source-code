package com.packtpub.vaadin.widget;

import com.packtpub.vaadin.widget.client.tristatecheckbox.TriStateCheckboxServerRpc;
import com.packtpub.vaadin.widget.client.tristatecheckbox.TriStateCheckboxState;

@SuppressWarnings("serial")
public class TriStateCheckbox extends com.vaadin.ui.CheckBox {

    private TriStateCheckboxServerRpc rpc = new TriStateCheckboxServerRpc() {

		@Override
		public void valueChanged(boolean value) {			
			setValue(value);
			setIndeterminate(false);
		}        
    };  

	public TriStateCheckbox(String text) {		
		getState().text = text;
		registerRpc(rpc);
	}

    @Override
    public TriStateCheckboxState getState() {
        return (TriStateCheckboxState) super.getState();
    }
    
	public void setIndeterminate(boolean indeterminate) {
		getState().indeterminate = indeterminate;
	}

	public boolean isIndeterminate() {
		return getState().indeterminate;
	}

}
