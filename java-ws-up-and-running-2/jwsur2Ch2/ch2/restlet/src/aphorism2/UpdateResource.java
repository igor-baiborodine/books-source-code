package aphorism2;

import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.data.Status;
import org.restlet.data.MediaType;
import org.restlet.data.Form;

public class UpdateResource extends ServerResource {
    public UpdateResource() { }

    @Put
    public Representation update(Representation data) {
	Status status = null;
	String msg = null;

	// Extract the data from the POST body.
	Form form = new Form(data);
	String sid = form.getFirstValue("id");
	String words = form.getFirstValue("words");

	if (sid == null || words == null) {
	    msg = "An ID and new words must be provided.\n";
	    status = Status.CLIENT_ERROR_BAD_REQUEST;
	}
	else {
	    int id = Integer.parseInt(sid.trim());
	    Adage adage = Adages.find(id);
	    if (adage == null) {
		msg = "There is no adage with ID " + id + "\n";
		status = Status.CLIENT_ERROR_BAD_REQUEST;
	    }
	    else {
		adage.setWords(words);
		msg = "Adage " + id + " has been updated to '" + words + "'.\n";
		status = Status.SUCCESS_OK;
	    }
	}

	setStatus(status);
	return new StringRepresentation(msg, MediaType.TEXT_PLAIN);
    }
}


