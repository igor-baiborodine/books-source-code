package chapter12.code.listing.dwr;

import org.apache.log4j.Logger;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;

public class MyScriptSessionListener implements ScriptSessionListener {
	private static Logger logger = Logger.getLogger(MyScriptSessionListener.class);
	
	public void sessionCreated(ScriptSessionEvent scriptEvent) {
		logger.info("Script Session created : " + scriptEvent.getSession().getId());
	}

	public void sessionDestroyed(ScriptSessionEvent scriptEvent) {
		logger.info("Script Session destroyed : " + scriptEvent.getSession().getId());
	}
}
