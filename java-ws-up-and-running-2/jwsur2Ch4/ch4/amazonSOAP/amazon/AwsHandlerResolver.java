package amazon; 

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AwsHandlerResolver implements HandlerResolver {
    private String awsSecretKey;
    
    public AwsHandlerResolver(String awsSecretKey) {
	this.awsSecretKey = awsSecretKey;
    }
    
    public List<Handler> getHandlerChain(PortInfo portInfo) {
	List<Handler> handlerChain = new ArrayList<Handler>();
	
	QName serviceQName = portInfo.getServiceName();
	if(serviceQName.getLocalPart().equals("AWSECommerceService")) {
	    handlerChain.add(new AwsSoapHandler(awsSecretKey));
	}
	return handlerChain;
    }
}

class AwsSoapHandler implements SOAPHandler<SOAPMessageContext> {
    private byte[ ] secretBytes;
    
    public AwsSoapHandler(String awsSecretKey) {
	secretBytes = getBytes(awsSecretKey);
    }
    
    public void close(MessageContext mCtx) { }
    public Set<QName> getHeaders() { return null; }
  
    public boolean handleFault(SOAPMessageContext mCtx) {
	return true;
    }
    
    public boolean handleMessage(SOAPMessageContext mCtx) {
	Boolean outbound = (Boolean) mCtx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
	if (outbound) {
	    try {
		SOAPMessage soapMessage = mCtx.getMessage();
		SOAPBody soapBody = soapMessage.getSOAPBody();
		Node firstChild = soapBody.getFirstChild(); // operation name
		
		String timeStamp = getTimestamp();
		String signature = getSignature(firstChild.getLocalName(), timeStamp, secretBytes);
		append(firstChild, "Signature", signature);
		append(firstChild, "Timestamp", timeStamp);
	    } 
	    catch(Exception e) {
		throw new RuntimeException("SOAPException thrown.", e);
	    }
	}
	return true; // continue down the handler chain
    }
    
    private String getSignature(String operation, String timeStamp, byte[ ] secretBytes) {
	try {
	    String toSign = operation + timeStamp;
	    byte[] toSignBytes = getBytes(toSign);
	    
	    Mac signer = Mac.getInstance("HmacSHA256");
	    SecretKeySpec keySpec = new SecretKeySpec(secretBytes, "HmacSHA256");
	    
	    signer.init(keySpec);
	    signer.update(toSignBytes);
	    byte[] signBytes = signer.doFinal();
	    
	    String signature = new String(Base64.encodeBase64(signBytes));
	    return signature;
	} 
	catch(Exception e) {
	    throw new RuntimeException("NoSuchAlgorithmException thrown.", e);
	} 
    }
    
    private String getTimestamp() {
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
	return dateFormat.format(calendar.getTime());
    }
    
    private void append(Node node, String elementName, String elementText) {
	Element element = node.getOwnerDocument().createElement(elementName);
	element.setTextContent(elementText);
	node.appendChild(element);
    }

    private byte[ ] getBytes(String str) {
	try {
	    return str.getBytes("UTF-8");
	}
	catch(Exception e) { throw new RuntimeException(e); }
    }
}

