package com.visualization;

import com.vaadin.shared.ComponentState;
import com.vaadin.shared.ui.JavaScriptComponentState;

public class LineGraphState extends JavaScriptComponentState {
	
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
