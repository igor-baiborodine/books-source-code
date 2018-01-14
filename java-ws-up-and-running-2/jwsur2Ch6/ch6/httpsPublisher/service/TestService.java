package service;

import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;

public class TestService implements IService {
    public void doGet(HttpExchange e) { respond2Client(e, "doGet"); }
    public void doPost(HttpExchange e) { respond2Client(e, "doPost"); }
    public void doPut(HttpExchange e) { respond2Client(e, "doPut"); }
    public void doDelete(HttpExchange e) { respond2Client(e, "doDelete"); }

    private void respond2Client(HttpExchange ex, String response) { 
	try {
	    ex.sendResponseHeaders(200, 0); // 0 == as many bytes as there are
	    OutputStream out = ex.getResponseBody();
	    out.write(response.getBytes());
	    out.close(); // effectively ends session
	}
	catch(Exception e) { throw new RuntimeException(e); }
    }
}
