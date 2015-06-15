package com;

import com.vaadin.event.ItemClickEvent;

/**
 * @author Ondrej Kvasnovsky
 */
public class NavigationTreeListener implements ItemClickEvent.ItemClickListener {

    @Override
    public void itemClick(ItemClickEvent event) {

        Object value = event.getItemId();
        MyVaadinUI current = MyVaadinUI.getCurrent();

        // we should do this in a bit more elegant way (not just use labels from the tree)
        // we can add e.g. object structure fetched from database to the tree
        ContentLayout contentLayout = current.getPageLayout().getBodyLayout().getContentLayout();
        contentLayout.removeAllComponents();

        if (NavigationTree.REPORTS_LABEL.equals(value)) {
            ReportsLayout layout = new ReportsLayout();
            contentLayout.addComponent(layout);
        } else if (NavigationTree.MY_REPORTS_LABEL.equals(value)) {
            MyReportsLayout layout = new MyReportsLayout();
            contentLayout.addComponent(layout);
        }
    }
}
