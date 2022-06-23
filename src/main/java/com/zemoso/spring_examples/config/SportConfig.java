package com.zemoso.spring_examples.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.zemoso.spring_examples")
public class SportConfig {

    @Bean
    public SessionFactory sessionFactoryBean() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addAnnotatedClass(com.zemoso.spring_examples.entity.Student.class);
        configuration.configure("hibernate.cfg.xml");
        return configuration.buildSessionFactory();
    }

}
