package app

import com.vaadin.ui.VerticalLayout

import java.awt.TextField;

import com.vaadin.ui.UI
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.grails.Grails
import vaadin.grails.gorm.User

/**
 *
 *
 * @author
 */
class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true)

        List<User> users = User.list()
        for (User user : users) {
            String name = user.name
            layout.addComponent(new Label("User name: " + name))
        }
    }
}
