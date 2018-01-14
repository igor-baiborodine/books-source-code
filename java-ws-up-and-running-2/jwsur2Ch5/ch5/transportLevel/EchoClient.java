import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import echoClient.EchoService;
import echoClient.Echo;

public class EchoClient {
    private static final String defaultUrl = "http://localhost:7777/echo";
    public static void main(String[ ] args) {
	Echo port = new EchoService().getEchoPort();
	Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();

	/* Sample invocation: 
	   java EchoClient http://localhost:7777/ echo
	*/
	String url = (args.length >= 2) ? (args[0] + args[1]) : defaultUrl;
	requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
	
	// Add application-specific HTTP header blocks.
	Map<String, Object> myHeaders = new HashMap<String, Object>();
	myHeaders.put("Accept-Encoding", Collections.singletonList("gzip"));
	myHeaders.put("Greeting", Collections.singletonList("Hello, world!"));
	requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, myHeaders);
	
	String response = port.echo("Have a nice day :)");
	Map<String, Object> responseContext = ((BindingProvider) port).getResponseContext();
	dump(responseContext, "");
    }

    private static void dump(Map map, String indent) {
	Set keys = map.keySet();
	for (Object key : keys) {
	    System.out.println(indent + key + " : " + map.get(key));
	    if (map.get(key) instanceof Map)
		dump((Map) map.get(key), indent += "  ");
	}
    }
}