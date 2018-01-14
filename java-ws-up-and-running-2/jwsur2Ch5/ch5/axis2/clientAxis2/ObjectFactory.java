
package clientAxis2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clientAxis2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EchoArgs0_QNAME = new QName("http://hello", "args0");
    private final static QName _EchoResponseReturn_QNAME = new QName("http://hello", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientAxis2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Echo }
     * 
     */
    public Echo createEcho() {
        return new Echo();
    }

    /**
     * Create an instance of {@link EchoResponse }
     * 
     */
    public EchoResponse createEchoResponse() {
        return new EchoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hello", name = "args0", scope = Echo.class)
    public JAXBElement<String> createEchoArgs0(String value) {
        return new JAXBElement<String>(_EchoArgs0_QNAME, String.class, Echo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hello", name = "return", scope = EchoResponse.class)
    public JAXBElement<String> createEchoResponseReturn(String value) {
        return new JAXBElement<String>(_EchoResponseReturn_QNAME, String.class, EchoResponse.class, value);
    }

}
