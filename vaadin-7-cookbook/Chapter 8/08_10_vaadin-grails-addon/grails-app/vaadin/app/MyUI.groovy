package app

import com.vaadin.ui.UI
import com.vaadin.server.VaadinRequest
import com.vaadin.addon.calendar.ui.Calendar
import com.vaadin.ui.VerticalLayout

class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout()
        layout.setMargin(true)
        setContent(layout)

        Calendar calendar = new Calendar()
        layout.addComponent calendar
    }
}
