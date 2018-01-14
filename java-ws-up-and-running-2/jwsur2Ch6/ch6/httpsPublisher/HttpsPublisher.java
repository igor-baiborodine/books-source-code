import java.net.InetSocketAddress;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import javax.xml.ws.http.HTTPException;
import java.io.OutputStream;
import java.io.InputStream;
import java.security.SecureRandom;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsServer;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpsParameters;
import service.IService;

public class HttpsPublisher {
    private static final int defaultPort = 3443; 
    private static final int backlog = 12;      
    private static final String keystore = "test.keystore"; 
    private IService serviceInstance;                                           

    public static void main(String[ ] args) {
	if (args.length < 2) {
	    System.err.println("Usage: java HttpsPublisher <service> <path>");
	    return;
	}
	// % java HttpsPublisher myService.Service /service 
	new HttpsPublisher().init(args[0],  // service name
				  args[1]); // URI
    }

    private void init(String serviceName, String uri) {
	try {
	    Class serviceClass = Class.forName(serviceName);     
	    serviceInstance = (IService) serviceClass.newInstance();           
	}
	catch(Exception e) { throw new RuntimeException(e); }

	HttpsServer server = getHttpsServer(uri, defaultPort);
	if (server != null) {
	    server.createContext(uri);                                         
	    System.out.println("Server listening on port " + defaultPort);
	    server.start();                                                    
	}
	else
	    throw new RuntimeException("Cannot create server instance.");

    }

    private HttpsServer getHttpsServer(String uri, int port) {
	HttpsServer server = null;
	try {
	    InetSocketAddress inet = new InetSocketAddress(port);
	    server = HttpsServer.create(inet, backlog);                        
	    SSLContext sslCtx = SSLContext.getInstance("TLS");

	    // password for keystore
	    char[ ] password = "qubits".toCharArray();
	    KeyStore ks = KeyStore.getInstance("JKS");
	    FileInputStream fis = new FileInputStream(keystore);
	    ks.load(fis, password);

	    KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
	    kmf.init(ks, password);

	    TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
	    tmf.init(ks); // same as keystore
	    sslCtx.init(kmf.getKeyManagers(), 
			tmf.getTrustManagers(), 
			new SecureRandom()); 

	    // Create SSL engine and configure HTTPS to use it.
	    final SSLEngine eng = sslCtx.createSSLEngine();
	    server.setHttpsConfigurator(new HttpsConfigurator(sslCtx) {
		    public void configure(HttpsParameters parms) {
			parms.setCipherSuites(eng.getEnabledCipherSuites());
			parms.setProtocols(eng.getEnabledProtocols());
		    }
		});
	    server.setExecutor(null); // use default, hence single-threaded
	    server.createContext(uri, new MyHttpsHandler(this.serviceInstance));
	}
	catch(Exception e) { throw new RuntimeException(e); }
	return server;
    }
}

// The handle method is called on a particular request context,
// in this case on any request to the server that ends with /<uri>.
class MyHttpsHandler implements HttpHandler {
    private IService service; 

    public MyHttpsHandler(IService service) {
	this.service = service;
    }

    public void handle(HttpExchange ex) {
	// Implement a simple routing table.
        String verb = ex.getRequestMethod().toUpperCase();
	if (verb.equals("GET"))         service.doGet(ex);
	else if (verb.equals("POST"))   service.doPost(ex);
	else if (verb.equals("PUT"))    service.doPut(ex);
	else if (verb.equals("DELETE")) service.doDelete(ex);
	else throw new HTTPException(405);
    }
}
