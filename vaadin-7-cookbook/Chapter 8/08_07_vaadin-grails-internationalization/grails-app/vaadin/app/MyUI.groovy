package app

import com.vaadin.ui.UI
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.grails.Grails

/**
 *
 *
 * @author
 */
class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        String home = Grails.i18n("default.home.label")
        Label lblHome = new Label(home)
        addComponent(lblHome)
		
		String homeEng = Grails.i18n("default.home.label", Locale.ENGLISH)
		Label lblHomeEng = new Label(homeEng)
		addComponent(lblHomeEng)
		
		Object[] newItemArgs = ["iPhone"]
		String newItem = Grails.i18n("default.new.label", newItemArgs, null)
		Label lblNewItem = new Label(newItem)
		addComponent(lblNewItem)
		
		Object[] newItemArgsEng = ["iPhone"]
		String newItemEng = Grails.i18n("default.new.label", newItemArgs, Locale.ENGLISH)
		Label lblNewItemEng = new Label(newItemEng)
		addComponent(lblNewItemEng)
		
		Object[] newItemArgsDef = ["iPhone"]
		String newItemEngDef = Grails.i18n("doesnt.exist", newItemArgs, "There is a new {0}", Locale.ENGLISH)
		Label lblNewItemEngDef = new Label(newItemEngDef)
		addComponent(lblNewItemEngDef)
		
    }
}
