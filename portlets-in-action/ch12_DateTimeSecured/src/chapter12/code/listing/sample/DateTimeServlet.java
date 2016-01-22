package chapter12.code.listing.sample;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateTimeServlet extends HttpServlet {

	private static final long serialVersionUID = -7000894049885643392L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<String> userRoles = (List<String>) request.getSession(false)
				.getAttribute("userRoles");
		OutputStream outStream = response.getOutputStream();
		StringBuffer buffer = new StringBuffer();
		if (userRoles != null && userRoles.contains("User")) {
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
