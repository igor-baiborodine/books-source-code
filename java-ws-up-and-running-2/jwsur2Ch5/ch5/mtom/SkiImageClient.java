import clientMTOM.SkiImageServiceService;
import clientMTOM.SkiImageService;
import java.util.List;
import javax.activation.DataHandler;

public class SkiImageClient {
    public static void main(String[ ] args) {
	SkiImageService port = new SkiImageServiceService().getSkiImageServicePort();
	DataHandler image = port.getImage("nordic");
	dump(image);
	List<DataHandler> images = port.getImages();
	for (DataHandler dh : images) dump(dh);
    }
    private static void dump(DataHandler dh) {
	try {
	    System.out.println("MIME type: " + dh.getContentType());
	    System.out.println("Content:   " + dh.getContent());
	}
	catch(Exception e) { throw new RuntimeException(e); }
    }
}