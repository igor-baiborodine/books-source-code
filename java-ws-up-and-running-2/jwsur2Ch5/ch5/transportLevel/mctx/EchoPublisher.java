package mctx;

import javax.xml.ws.Endpoint;

public class EchoPublisher {
    public static void main(String[ ] args) {
	String url = "http://localhost:7777/echo";
	System.out.println("Echo service endpoint: " + url);
	Endpoint.publish(url, new Echo());
    }
}