package com.app;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class LoginLayout extends VerticalLayout {

    private Button btnLogin = new Button("Login");
    private TextField txtUsername = new TextField("Username:");
    private TextField txtPassword = new TextField("Password:");

    private UserService userService;

    public void init() {
        setMargin(true);
        addComponent(txtUsername);
        addComponent(txtPassword);
        addComponent(btnLogin);
        btnLogin.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                String username = txtUsername.getValue();
                String password = txtPassword.getValue();
                User user = userService.login(username, password);
                UI.getCurrent().setData(user);
            }
        });
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public TextField getTxtUsername() {
        return txtUsername;
    }

    public TextField getTxtPassword() {
        return txtPassword;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
