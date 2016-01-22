package chapter03.code.listing.utils;

import javax.portlet.PortletURL;
import javax.portlet.PortletURLGenerationListener;
import javax.portlet.ResourceURL;
import javax.portlet.WindowState;

public class MyUrlGenerationListener implements PortletURLGenerationListener {

	public void filterActionURL(PortletURL actionUrl) {
		try {
			actionUrl.setWindowState(WindowState.MAXIMIZED);
			//actionUrl.setSecure(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void filterRenderURL(PortletURL renderUrl) {
		try {
			renderUrl.setWindowState(WindowState.MAXIMIZED);
			//renderUrl.setSecure(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void filterResourceURL(ResourceURL arg0) {
	}
}
