package hello;

public class HiService {              // service
    public String echo(String name) { // service operation
	String msg = (name == null || name.length() < 1) ? "Hello, world!" : 
	    "Hello, " + name + "!";
	return msg;
    }
}
