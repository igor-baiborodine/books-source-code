import java.util.List;
import java.util.LinkedList;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Binding;
import echoClient.EchoService;
import echoClient.Echo;

public class EchoClientWSS {
    public static void main(String[ ] args) {

        try { 
	    List<Handler> hchain = new LinkedList<Handler>();
	    hchain.add(new ClientHandler());

            EchoService service = new EchoService();
            Echo port = service.getEchoPort();
	    Binding binding = ((BindingProvider) port).getBinding();
	    binding.setHandlerChain(hchain);

            String response = port.echo("Goodbye, cruel world!");
            System.out.println("From Echo service: " + response);
        } 
	catch (Exception e) { throw new RuntimeException(e); }
    }
}

