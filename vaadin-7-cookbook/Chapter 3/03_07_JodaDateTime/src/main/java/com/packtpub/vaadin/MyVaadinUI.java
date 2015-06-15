package com.packtpub.vaadin;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.joda.time.DateTime;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{

    @Override
    protected void init(VaadinRequest request) {


        Post post = new Post();
        String label = "I really need that stuff.";
        post.setText(label);
        DateTime crated = DateTime.now();
        post.setCreated(crated);

        BeanItem<Post> postBean = new BeanItem<Post>(post);
        FieldGroup fieldGroup = new FieldGroup(postBean);
        FieldGroupFieldFactory fieldFactory = new JodaFieldFactory();
        fieldGroup.setFieldFactory(fieldFactory);
        FormLayout formLayout = new FormLayout();

        formLayout.addComponent(fieldGroup.buildAndBind("text"));
        formLayout.addComponent(fieldGroup.buildAndBind("created"));

        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        layout.addComponent(formLayout);
    }
}
