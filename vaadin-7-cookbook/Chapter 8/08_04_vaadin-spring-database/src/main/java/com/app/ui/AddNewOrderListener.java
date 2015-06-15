package com.app.ui;

import com.app.dao.OrderDAO;
import com.app.model.Order;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import org.springframework.context.ApplicationContext;

/**
 * @author Ondrej Kvasnovsky
 */
public class AddNewOrderListener implements Button.ClickListener {

    @Override
    public void buttonClick(Button.ClickEvent event) {
        OrdersView view = (OrdersView) event.getButton().getParent();

        AppUI current = (AppUI) (UI.getCurrent());
        ApplicationContext context = current.getApplicationContext();

        OrderDAO orderDAO = context.getBean(OrderDAO.class);

        TextField txtOrderLabel = view.getTxtOrderLabel();
        String value = txtOrderLabel.getValue();

        Order order = new Order();
        order.setLabel(value);
        orderDAO.save(order);

        current.getNavigator().navigateTo("orders");
    }
}
