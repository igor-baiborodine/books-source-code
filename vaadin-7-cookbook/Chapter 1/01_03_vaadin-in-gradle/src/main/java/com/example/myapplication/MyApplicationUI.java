package com.example.myapplication;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.Label;

public class MyApplicationUI extends UI{
	
	@Override
	protected void init(VaadinRequest request){
		Label lbl = new Label("Hello vaadin");
		setContent(lbl);
	}
}
