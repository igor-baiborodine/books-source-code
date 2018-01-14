package echoService;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class Echo {
    @WebMethod
    public String echo(String msg) { return "Echoing: " + msg; }
}

