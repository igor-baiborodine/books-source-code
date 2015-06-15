package app

import com.vaadin.ui.*
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.grails.Grails
import vaadin.grails.services.User
import vaadin.grails.services.UserService

/**
 *
 *
 * @author
 */
class MyUI extends UI {

	TextField txtName = new TextField("Name: ");
    VerticalLayout layout = new VerticalLayout()

	@Override
	protected void init(VaadinRequest vaadinRequest) {
        layout.margin = true
        setContent(layout)

        layout.addComponent(txtName);

		Button btnAdd = new Button("Add");
        layout.addComponent(btnAdd);
		btnAdd.addClickListener(new AddUserListener());

		List<User> users = Grails.get(UserService).getAll()
		for (User user : users) {
            layout.addComponent(new Label(user.name))
		}
	}
}
