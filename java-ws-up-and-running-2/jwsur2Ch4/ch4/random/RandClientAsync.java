import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.util.List;
import clientAsync.RandServiceService;
import clientAsync.RandService;
import clientAsync.NextNResponse;

public class RandClientAsync {
    public static void main(String[ ] args) {
	RandServiceService service = new RandServiceService();
	RandService port = service.getRandServicePort();
	port.nextNAsync(4, new MyHandler());
	try {
	    Thread.sleep(5000); // in production, do something useful!
	}
	catch(Exception e) { }
	System.out.println("\nmain is exiting...");
    }

    static class MyHandler implements AsyncHandler<NextNResponse> {
        public void handleResponse(Response<NextNResponse> future) {
	    try {
		NextNResponse response = future.get();
		List<Integer> nums = response.getReturn();
		for (Integer num : nums) System.out.println(num);
	    }
	    catch(Exception e) { System.err.println(e); }
        }
    }
}