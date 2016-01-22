package chapter12.code.listing.dwr;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import chapter12.code.listing.utils.BookDataObject;

public class UpdateSender implements Runnable {
	protected boolean running = true;
	private static UpdateSender updateSender;
	private Set<ScriptSession> scriptSessions = new HashSet<ScriptSession>();
	private static int initialBookCount = 0;
	private static Logger logger = Logger.getLogger(UpdateSender.class);
	private ServletContext context;
	private String portletNamespace;
	
	private UpdateSender(ServletContext context, String portletNamespace) {
		this.context = context;
		this.portletNamespace = portletNamespace;
	}
	
	public static UpdateSender getInstance(ServletContext context, String portletNamespace) {
		if(updateSender == null) {
			updateSender = new UpdateSender(context, portletNamespace);
			Thread updateSenderThread = new Thread(updateSender, "Book Catalog update sender thread");
			updateSenderThread.setDaemon(true);
			updateSenderThread.start( );
			BookDataObject books = (BookDataObject) context.getAttribute("bookCatalog");
			initialBookCount = books.getBooks().size();
		}
		return updateSender;
	}
	
	public synchronized void addScriptSession(ScriptSession scriptSession) {
	      Set<ScriptSession> scriptSessionsCopy = new HashSet<ScriptSession>(scriptSessions);
	      scriptSessionsCopy.add(scriptSession);
	      scriptSessions = scriptSessionsCopy;
	}
	
	public void run() {
		while(running) {
			BookDataObject books = (BookDataObject) context.getAttribute("bookCatalog");
			int currentBookCount = books.getBooks().size();
			
			if(currentBookCount != initialBookCount) {
				//-- send an update to all the registered connections
					Iterator<ScriptSession> iterator = scriptSessions.iterator();
					while(iterator.hasNext()) {
						ScriptSession scriptSession = iterator.next();
						logger.info("Script Session's & last creation time: " + scriptSession + " & " + scriptSession.getLastAccessedTime());
						if(!scriptSession.isInvalidated()) {
							ScriptBuffer scriptBuffer = new ScriptBuffer();
							scriptBuffer.appendScript(portletNamespace + "showBookUpdateMsg()");
							scriptSession.addScript(scriptBuffer);
						} else {
							logger.info("Removing script Session " + scriptSession + " with last accessed time " + scriptSession.getLastAccessedTime());
							synchronized(this) {
								iterator.remove();
							}
						}	
						initialBookCount = currentBookCount;
				   } 
			  }
		  }
	  }
	
	 public void stop() {
         running = false;
     }
}