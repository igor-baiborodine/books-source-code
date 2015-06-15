package com.app;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ondrej Kvasnovsky
 */
public class LoginLayoutTest {

    private LoginLayout loginLayout;

    @Before
    public void setUp() throws Exception {
        loginLayout = new LoginLayout();
        loginLayout.init();

        UI.setCurrent(new MyVaadinUI());

        loginLayout.setUserService(new UserService() {
            @Override
            public User login(String username, String password) {
                return new User();
            }
        });
    }

    @Test
    public void isLoginButtonPresent() {
        Button btnLogin = loginLayout.getBtnLogin();
        int index = loginLayout.getComponentIndex(btnLogin);

        Component component = loginLayout.getComponent(index);
        Assert.assertEquals(btnLogin, component);
    }

    @Test
    public void isLoginWorking() {
        TextField txtUsername = loginLayout.getTxtUsername();
        txtUsername.setValue("myusername");
        TextField txtPassword = loginLayout.getTxtPassword();
        txtPassword.setValue("mypassword");
        Button btnLogin = loginLayout.getBtnLogin();
        btnLogin.click();

        User user = (User) UI.getCurrent().getData();
        Assert.assertNotNull(user);
    }

    @Test
    public void isUsernameTextFieldInitializedProperly() {
        TextField txtUsername = loginLayout.getTxtUsername();
        int index = loginLayout.getComponentIndex(txtUsername);

        Assert.assertEquals(txtUsername, loginLayout.getComponent(index));
    }

    @Test
    public void isPasswordTextFieldInitializedProperly() {
        loginLayout.init();
        TextField txtPassword = loginLayout.getTxtPassword();
        int index = loginLayout.getComponentIndex(txtPassword);

        Assert.assertEquals(txtPassword, loginLayout.getComponent(index));
    }

    @Test
    public void doesLoginButtonHaveProperCaption() {
        Button btnLogin = loginLayout.getBtnLogin();
        String caption = btnLogin.getCaption();
        Assert.assertEquals("Login", caption);
    }

    @Test
    public void isLoginButtonVisible() {
        Button btnLogin = loginLayout.getBtnLogin();
        boolean visible = btnLogin.isVisible();
        Assert.assertEquals(true, visible);
    }

    @Test
    public void isLoginButtonEnabled() {
        Button btnLogin = loginLayout.getBtnLogin();
        boolean enabled = btnLogin.isEnabled();
        Assert.assertEquals(true, enabled);
    }
}
