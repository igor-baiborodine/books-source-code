package com.packtpub.vaadin;

import com.packtpub.vaadin.magic.PrincessCardTrick;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
public class MagicTrick extends UI {

	@Override
	protected void init(VaadinRequest request) {		
		setContent(new PrincessCardTrick());
	}

}