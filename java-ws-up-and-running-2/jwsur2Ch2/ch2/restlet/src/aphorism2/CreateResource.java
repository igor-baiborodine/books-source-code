package aphorism2;

import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.data.Status;
import org.restlet.data.MediaType;
import org.restlet.data.Form;

public class CreateResource extends ServerResource {
    public CreateResource() { }

    @Post
    public Representation create(Representation data) {
	Status status = null;
	String msg = null;

	// Extract the data from the POST body.
	Form form = new Form(data);
	String words = form.getFirstValue("words");

	if (words == null) {
	    msg = "No words were given for the adage.\n";
	    status = Status.CLIENT_ERROR_BAD_REQUEST;
	}
	else {
	    Adages.add(words);
	    msg = "The adage '" + words + "' has been added.\n";
	    status = Status.SUCCESS_OK;
	}

	setStatus(status);
	return new StringRepresentation(msg, MediaType.TEXT_PLAIN);
    }
}


