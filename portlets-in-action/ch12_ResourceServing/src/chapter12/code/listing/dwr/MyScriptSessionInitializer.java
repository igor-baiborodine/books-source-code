package chapter12.code.listing.dwr;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.directwebremoting.Container;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;

public class MyScriptSessionInitializer extends HttpServlet {
	private static final long serialVersionUID = -2168558001286798032L;
	private static Logger logger = Logger.getLogger(MyScriptSessionInitializer.class);
	
	public void init() {
		logger.info("Initializing MyScriptSessionInitializer servlet");
		Container container = ServerContextFactory.get().getContainer(); 
        ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
        ScriptSessionListener scriptSessionListener = new MyScriptSessionListener();
        manager.addScriptSessionListener(scriptSessionListener); 
	}
}
