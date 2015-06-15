package com.packtpub.vaadin;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

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

        FlotChart flot = new FlotChart();
        flot.setWidth("300px");
        flot.setHeight("300px");

        //String options = "{ grid: { backgroundColor: { colors: [\"#fef\", \"#eee\"] } } }";
        String options =
        "{" +
            "grid:{"         +
                "backgroundColor:{" +
                    "colors:["+
                    "\"#fef\"," +
                            "\"#eee\""+
                    "]"+
                "}"+
            "}"+
        "}";
        String data =
        "[" +
            "[" +
                "[0, 5]," +
                "[2, 7]," +
                "[4, 8]," +
                "[10, 5]" +
            "]" +
        "]";

        flot.setData(data);
        flot.setOptions(options);
        layout.addComponent(flot);
    }
}
