package images;
import javax.xml.ws.Endpoint;

public class SkiImagePublisherBase64 {
    public static void main(String[ ] args) {
	System.out.println("URL: http://localhost:9876/ski");	
	Endpoint.publish("http://localhost:9876/ski", new SkiImageService());
    }
}