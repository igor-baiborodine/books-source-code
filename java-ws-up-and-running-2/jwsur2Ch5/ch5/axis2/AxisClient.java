import clientAxis2.HiPortType;
import clientAxis2.Hi;
import javax.xml.ws.BindingProvider;

public class AxisClient {
    public static void main(String[ ] args) {
	final String endpoint = "http://localhost:8080/axis2/services/hi";

	HiPortType port = new Hi().getHiHttpEndpoint();

	// Override the endpoint in the wsimport-derived classes.
	BindingProvider bp = (BindingProvider) port; 
	bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

	System.out.println(port.echo(null));
	System.out.println(port.echo("Fred"));
    }
}