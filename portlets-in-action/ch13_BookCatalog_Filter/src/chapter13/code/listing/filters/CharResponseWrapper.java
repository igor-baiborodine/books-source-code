package chapter13.code.listing.filters;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.portlet.RenderResponse;
import javax.portlet.filter.RenderResponseWrapper;

public class CharResponseWrapper extends RenderResponseWrapper {
	private CharArrayWriter writer;
	
	public String toString() {
		return writer.toString();
	}
	
	public CharResponseWrapper(RenderResponse response) {
		super(response);
		writer = new CharArrayWriter();
	}
	
	public PrintWriter getWriter() throws java.io.IOException {
		return new PrintWriter(writer);
	}
}
