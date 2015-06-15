package com.app;

import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.Root;
import com.visualization.LineGraph;

public class VisualizationRoot extends Root {

	@Override
	public void init(WrappedRequest request) {
		final LineGraph graph = new LineGraph();
		graph.setDebugId("chart");
		graph.setWidth("400px");
		graph.setHeight("300px");
		String data = "";
		graph.setData(data);
		addComponent(graph);
	}
}
