/**
 * 
 */
package app;

import vaadin.grails.services.User
import vaadin.grails.services.UserService

import com.vaadin.grails.Grails
import com.vaadin.ui.*
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Button.ClickListener

/**
 * @author ondrej
 */
public class AddUserListener implements ClickListener {

	@Override
	public void buttonClick(ClickEvent event) {
		MyUI ui = (MyUI) UI.getCurrent()
		String value = ui.txtName.getValue()
		User user = Grails.get(UserService).add(value)
		ui.layout.addComponent(new Label(user.name))
	}
}
