package com.packtpub.vaadin.complextable;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.Action;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.shared.MouseEventDetails.MouseButton;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Table;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class CRUD extends HorizontalSplitPanel {

	private final static Action ACTION_ADD = new Action("Add");
	private final static Action ACTION_DELETE = new Action("Delete");
	private int id = 0;
	private BeanItemContainer<Product> products = new BeanItemContainer<>(Product.class);

	public CRUD() {		
		fillContainer(products);
		setFirstComponent(createTable(products));
	}

	private Table createTable(Container container) {		
		final Table table = new Table(null, container);	
		table.setSelectable(true);
		table.setSizeFull();
		table.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				if (MouseButton.LEFT.getName().equals(event.getButtonName())) {
					setSecondComponent(createForm(event.getItem()));
				}
			}
		});

		table.addActionHandler(new Handler() {
			@Override
			public void handleAction(Action action, Object sender, Object target) {
				if (ACTION_DELETE == action) {
					products.removeItem(target);
				}
				if (ACTION_ADD == action) {					
					products.addBean(new Product(id++, "", 0));					
				}
			}

			@Override
			public Action[] getActions(Object target, Object sender) {
				return new Action[] { ACTION_ADD, ACTION_DELETE };
			}
		});
		return table;
	}

	private Layout createForm(Item item) {
		FormLayout layout = new FormLayout();
		layout.setSpacing(true);
		layout.setMargin(true);
		final FieldGroup group = new FieldGroup(item);
		for (Object propertyId : group.getUnboundPropertyIds()) {
			layout.addComponent(group.buildAndBind(propertyId));
		}
		Button button = new Button("Commmit");
		button.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					group.commit();
				} catch (CommitException e) {
					Notification.show(e.getCause().getMessage(), Type.ERROR_MESSAGE);
				}
			}
		});
		layout.addComponent(button);
		return layout;
	}

	private void fillContainer(Container container) {		
		container.addItem(new Product(id++, "Computer", 599.90));
		container.addItem(new Product(id++, "Phone", 14.5));
		container.addItem(new Product(id++, "Tablet", 99.90));
		container.addItem(new Product(id++, "Mouse", 0.99));
	}

}
