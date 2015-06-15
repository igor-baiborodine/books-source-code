package com.app;

import com.jensjansson.pagedtable.ControlsLayout;
import com.jensjansson.pagedtable.PagedTable;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        PagedTable table = new PagedTable("Paged lazy loaded table");
        table.setWidth("500px");

        LazyLoadedContainer container = new LazyLoadedContainer(User.class);
        table.setContainerDataSource(container);
        layout.addComponent(table);

        ControlsLayout controls = table.createControls();
        controls.setWidth("500px");
        layout.addComponent(controls);
    }
}

class LazyLoadedContainer extends BeanContainer {

    private UserService userService = new UserService();
    private boolean dirty;
    private int lastSize;

    public LazyLoadedContainer(Class type) {
        super(type);

    }

    @Override
    public int size() {
        if (lastSize == 0 || dirty) {
            lastSize = userService.size();
        }
        return lastSize;
    }

    @Override
    public BeanItem getItem(Object itemId) {
        return new BeanItem((User) itemId);
    }

    @Override
    public List getItemIds(int startIndex, int numberOfIds) {
        int endIndex = startIndex + numberOfIds;
        System.out.println("startIndex: " + startIndex + ", endIndex: " + endIndex);
        List list = userService.list(startIndex, endIndex);
        return list;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    public int getLastSize() {
        return lastSize;
    }
}

