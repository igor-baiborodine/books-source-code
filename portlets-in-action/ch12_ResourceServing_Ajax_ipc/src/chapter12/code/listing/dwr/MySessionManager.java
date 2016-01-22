package chapter12.code.listing.dwr;

import org.directwebremoting.impl.DefaultScriptSession;
import org.directwebremoting.impl.DefaultScriptSessionManager;

public class MySessionManager extends DefaultScriptSessionManager {
	public long getScriptSessionTimeout() {
		long timeout = super.getScriptSessionTimeout();
		System.out.println("getScriptSessionTimeout " + timeout);
		return timeout;
	}
	
	protected void invalidate(DefaultScriptSession scriptSession) {
		System.out.println("Invalidate scriptSession " + scriptSession.getId());
		super.invalidate(scriptSession);
	}
}
