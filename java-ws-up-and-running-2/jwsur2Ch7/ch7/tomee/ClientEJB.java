import clientEJB.PredictionEJBService;
import clientEJB.PredictionEJB;
import clientEJB.Prediction;
import java.util.List;

public class ClientEJB {
    public static void main(String[ ] args) {
	new ClientEJB().runTests();
    }

    private void runTests() {
	PredictionEJB port = 
	    new PredictionEJBService().getPredictionEJBPort();
	create(port);
	getAll(port);
	edit(port);    // id == 2
	getOne(port);  // id == 2
	delete(port);  // id == 2
	getAll(port);
    }

    private void getAll(PredictionEJB port) {
	System.out.println("\n### getAll:");
	List<Prediction> predictions = port.getAll();
	for (Prediction pred : predictions) stringify(pred);
    }

    private void getOne(PredictionEJB port) {
	System.out.println("\n### getOne:");
	Prediction pred = port.getOne(2);
	stringify(pred);
    }

    private void create(PredictionEJB port) {
	System.out.println("\n### create:");
	String who = "River Friesen";
	String what = "Decentralized 24/7 hub will target robust web-readiness.";
	Prediction pred = port.create(who, what);
	stringify(pred);

	who = "Kaden Crona";
	what = "Optional static definition will unleash dynamic e-tailers.";
	pred = port.create(who, what);
	stringify(pred);
    }
    private void edit(PredictionEJB port) {
	System.out.println("\n### edit:");
	Prediction pred = port.edit(2, "Testing! New who", "Testing! New what");
	stringify(pred);
    }

    private void delete(PredictionEJB port) {
	System.out.println("\n### delete:");
	String msg = port.delete(2);
	System.out.println(msg);
    }

    private void stringify(Prediction pred) {
	if (pred == null) return;
	String s = String.format("%2d ", pred.getId()) +
	    pred.getWho() + " says: " + pred.getWhat();
	System.out.println(s);
    }
}