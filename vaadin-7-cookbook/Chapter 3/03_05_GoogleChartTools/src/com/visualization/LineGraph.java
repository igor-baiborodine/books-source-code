package com.visualization;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

@JavaScript({ "https://www.google.com/jsapi", "visualization_connector.js" })
public class LineGraph extends AbstractJavaScriptComponent {

	@Override
	public LineGraphState getState() {
		return (LineGraphState) super.getState();
	}

	public void setData(String data) {
		getState().setData(data);
		requestRepaint();
	}
}
