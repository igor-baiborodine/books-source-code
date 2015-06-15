package com.app.ui;

import com.app.model.Order;
import com.app.service.OrderService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @author Ondrej Kvasnovsky
 */
public class OrdersView extends VerticalLayout implements View {

    private TextField txtOrderLabel = new TextField("Order label: ");

    public void enter(ViewChangeListener.ViewChangeEvent event) {
        removeAllComponents();

        addComponent(txtOrderLabel);

        Button btnAddNewOrder = new Button("Add New Order");
        btnAddNewOrder.addClickListener(new AddNewOrderListener());
        addComponent(btnAddNewOrder);

        // render orders
        AppUI current = (AppUI) UI.getCurrent();
        ApplicationContext context = current.getApplicationContext();
        OrderService service = context.getBean(OrderService.class);

        List<Order> all = service.findAll();
        for (Order o : all) {
            String label = o.getLabel();
            Label lbl = new Label("Order label: " + label);
            addComponent(lbl);
        }
    }

    public TextField getTxtOrderLabel() {
        return txtOrderLabel;
    }
}
