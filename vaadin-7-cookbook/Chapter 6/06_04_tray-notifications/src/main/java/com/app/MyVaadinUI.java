package com.app;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Position;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

/**
 * The Application's "main" class
 */
@Theme("mytheme")
public class MyVaadinUI extends UI {

    public class NotifyListener implements Button.ClickListener {
        @Override
        public void buttonClick(ClickEvent event) {
            Notification.show("Good job!", Notification.Type.TRAY_NOTIFICATION);

            Notification notification = new Notification("Well done!",
                    "You have clicked on the button.",
                    Notification.Type.TRAY_NOTIFICATION);

//            notification.setDelayMsec(0);
            notification.setPosition(Position.TOP_RIGHT);
//            notification.setStyleName("mynotification");

            notification.show(Page.getCurrent());
        }
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        Button btn = new Button("Click me!");
        btn.addClickListener(new NotifyListener());

        layout.addComponent(btn);
    }

}
