package com.app.config;

import com.app.bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

/**
 * @author Ondrej Kvasnovsky
 */
@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean() {
        MyBean myBean = new MyBean("You are authenticated.", "You are NOT authenticated.");
        return myBean;
    }

}
