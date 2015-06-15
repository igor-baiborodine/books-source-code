package com.packtpub.vaadin.tabs;


import java.util.Iterator;

import javax.servlet.http.Cookie;

import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.server.VaadinServletResponse;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class TabsURL extends TabSheet{	
	private static final String tabNames[] = {"Home", "Contractors", "Customers", "Employees", "Help"};
	private static final String LAST_TAB_COOKIE_NAME = "vaadin_last_tab_name";	
	private static final String PATH = "/data";

	public TabsURL() {
		createTabs(tabNames);		
		addSelectedTabChangeListener(new SelectedTabChangeListener() {
			@Override
			public void selectedTabChange(SelectedTabChangeEvent event) {				
				String selectedTabName = event.getTabSheet().getSelectedTab().getCaption();
				UI.getCurrent().getPage().setUriFragment(selectedTabName);	
			}
		});
	}
	
	private void createTabs(String tabNames[]){
		for (String tabName : tabNames) {
			VerticalLayout layout = new VerticalLayout();
			layout.setCaption(tabName);
			layout.addComponent(new Label("<h1>" + tabName + "</h1>", ContentMode.HTML));
			layout.setHeight(400, Unit.PIXELS);
			addComponent(layout);			
		}
	}
	
	public void selectTab(){		
		String fragment = UI.getCurrent().getPage().getUriFragment();		
		if (fragment == null) {
			fragment = getLastTabNameFromCookies();
		}
		Iterator<Component> iterator = getComponentIterator();
		while (iterator.hasNext()){
			Component tab = iterator.next();
			String name = tab.getCaption().toLowerCase();
			if (fragment.toLowerCase().equals(name)){				
				setSelectedTab(tab);
				setLastTabNameToCookies(name);
				return;
			}
		}		
		setSelectedTab(0);
	}	

	
	private void setLastTabNameToCookies(String tabName) {
		Cookie lastTabCookie = new Cookie(LAST_TAB_COOKIE_NAME, tabName);
		lastTabCookie.setPath(PATH);
		VaadinServletResponse response = (VaadinServletResponse) VaadinService.getCurrentResponse();
		response.addCookie(lastTabCookie);		
	}
	
	private String getLastTabNameFromCookies() {		
		Cookie[] cookies = ((VaadinServletRequest) VaadinService.getCurrentRequest()).getCookies();
		for (Cookie cookie : cookies) {
			if (LAST_TAB_COOKIE_NAME.equals(cookie.getName())){
				return cookie.getValue();
			}
		}		
		return "";
	}


}
 