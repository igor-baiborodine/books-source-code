package chapter12.code.listing.utils;

import java.util.Map;

public class Message {
	private String statusCode;
	private String responseMessage;
	private Map<String, String> responseData;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public Map<String, String> getResponseData() {
		return responseData;
	}
	public void setResponseData(Map<String, String> responseData) {
		this.responseData = responseData;
	}
}