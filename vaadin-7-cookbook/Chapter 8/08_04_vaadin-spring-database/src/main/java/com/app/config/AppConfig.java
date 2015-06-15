package com.app.config;

import com.app.dao.OrderDAO;
import com.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author Ondrej Kvasnovsky
 */
@Configuration
@ComponentScan(basePackages = {"com.app.ui" , "com.app.service"})
public abstract class AppConfig {

    @Autowired
    private DriverManagerDataSource dataSource;

    @Bean
    public OrderService orderService() {
        OrderService res = new OrderService();
        return res;
    }

    @Bean
    public DriverManagerDataSource driverManagerDataSource() {
        String driverClassName = "org.h2.Driver";
        String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
        String username = "sa";
        String password = "";

        DriverManagerDataSource res = new DriverManagerDataSource();
        res.setDriverClassName(driverClassName);
        res.setUrl(url);
        res.setUsername(username);
        res.setPassword(password);
        return res;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public OrderDAO orderDAO() {
        return new OrderDAO ();
    }
}
