package chapter12.code.listing.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

/**
 * DateTimeController shows the add book form and handles requests
 * for adding a book to the catalog.
 * 
 * @author asarin
 *
 */
@Controller(value="dateTimeController")
@RequestMapping(value = "VIEW")
public class DateTimeController {
	@RenderMapping
	public String showBooks(RenderResponse response) {
		return "home";
	}
	
	@ResourceMapping("dateTime")
	public void getDateTime(ResourceRequest request, ResourceResponse response) throws IOException {
		OutputStream outStream = response.getPortletOutputStream();
		StringBuffer buffer = new StringBuffer();
		if (request.isUserInRole("User")) {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"dd-MMM-yyyy hh:mm:ss a");
			buffer.append("Hello World (<i> " + sdf.format(new Date())
					+ " </i>)");
		} else {
			buffer.append("<font color=\"red\"> You are not authorized to view server date/time");
		}
		outStream.write(buffer.toString().getBytes());
	}
}