package chapter12.code.listing.sample;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class DateTimeServlet extends HttpServlet {

	private static final long serialVersionUID = -7000894049885643392L;
	private Logger logger = Logger.getLogger(DateTimeServlet.class);
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		logger.info("invoking  DateTimeServlet");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
		OutputStream outStream = response.getOutputStream();
		StringBuffer buffer = new StringBuffer();
		buffer.append("<p>Hello World (<i> " + sdf.format(new Date()) + " </i>)</p>");
		outStream.write(buffer.toString().getBytes());
	}
}
