package app

import com.vaadin.ui._
import com.vaadin.server.VaadinRequest

class MyVaadinUI extends UI {
	def init(request: VaadinRequest) = {
		val layout = new VerticalLayout()
        layout.setMargin(true)
        setContent(layout)
		layout.addComponent(new Label("Hello Vaadin user."))
	}
}
