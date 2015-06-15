package com.app.config;

import com.app.auth.AuthManager;
import com.app.service.UserService;
import com.app.ui.LoginFormListener;
import com.app.ui.LoginView;
import com.app.ui.UserView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Ondrej Kvasnovsky
 */
@Configuration
@ComponentScan(basePackages = {"com.app.ui" , "com.app.auth", "com.app.service"})
public class AppConfig {

    @Bean
    public AuthManager authManager() {
        AuthManager res = new AuthManager();
        return res;
    }

    @Bean
    public UserService userService() {
        UserService res = new UserService();
        return res;
    }

    @Bean
    public LoginFormListener loginFormListener() {
        return new LoginFormListener();
    }
}
