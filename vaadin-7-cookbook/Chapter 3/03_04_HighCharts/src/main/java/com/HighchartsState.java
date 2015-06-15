/**
 * 
 */
package com;

import com.vaadin.shared.ui.JavaScriptComponentState;
import org.json.JSONObject;

/**
 * @author ondrej
 */
public class HighchartsState extends JavaScriptComponentState {

	private JSONObject data;

	public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}
}
