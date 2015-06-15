package com.packtpub.vaadin.widget.client.chromahashpasswordfield;

import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;

public class ChromaHashPasswordFieldWidget extends Composite {

	private PasswordTextBox textBox = new PasswordTextBox();
	private HTML chromaHashStripes = new HTML();
	private HorizontalPanel panel = new HorizontalPanel();
	private int numberStripes = 3;

	public static final String CLASSNAME = "chromahashpasswordfield";

	public ChromaHashPasswordFieldWidget() {
		initWidget(panel);
		setStyleName(CLASSNAME);
		panel.add(textBox);
		panel.add(chromaHashStripes);
	}
	
	public String getText() {
		return textBox.getText();
	}
	
	public void setText(String text) {
		textBox.setText(text);
	}
	
	public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {		
		return textBox.addKeyUpHandler(handler);		
	}	

	public void updateChromaHashStripes() {
		String[] chromaHash = getChromaHash(getText(), numberStripes);
		int height = 18;
		int width = 6;

		String htmlStripes = "<div style=\"margin: 3px;\">";
		for (int i = 0; i < numberStripes; i++) {
			htmlStripes += "<div style=\"background-color: " + chromaHash[i]
					+ "; float: left; height: " + height + "px; width: " + width
					+ "px;\"></div>";
		}
		htmlStripes += "</div>";
		chromaHashStripes.setPixelSize(height * 2, width * numberStripes);
		chromaHashStripes.setHTML(htmlStripes);
	}

	private String[] getChromaHash(String text, int numberStripes) {
		String salt = "du467e4aSdfe";
		text += salt;
		String[] colors = new String[numberStripes];
		int hash;
		int part = text.length() / numberStripes;
		for (int i = 0; i < numberStripes; i++) {
			hash = text.substring(part * i, (part * i) + part).hashCode();
			colors[i] = "#" + intToRGB(hash);
		}
		return colors;
	}

	public String intToRGB(int i) {
		return Integer.toHexString(((i >> 16) & 0xFF))
				+ Integer.toHexString(((i >> 8) & 0xFF))
				+ Integer.toHexString((i & 0xFF));
	}

}