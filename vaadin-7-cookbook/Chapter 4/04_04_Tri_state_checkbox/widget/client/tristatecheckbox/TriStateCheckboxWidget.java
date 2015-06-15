package com.packtpub.vaadin.widget.client.tristatecheckbox;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.CheckBox;

public class TriStateCheckboxWidget extends CheckBox {

	private boolean indeterminate = false;
    public static final String CLASSNAME = "tristatecheckbox";

    public TriStateCheckboxWidget() {        
        setStyleName(CLASSNAME);
    }
	
	public boolean isIndeterminate() {
		return indeterminate;
	}
	
	public void setIndeterminate(boolean indeterminate) {
		this.indeterminate = indeterminate;
		setVisualIndeterminate(getElement().getFirstChildElement(), indeterminate);
	}
	
	public final native String setVisualIndeterminate(Element checkbox, boolean indeterminate) /*-{
	  checkbox.indeterminate = indeterminate;
    }-*/;



}