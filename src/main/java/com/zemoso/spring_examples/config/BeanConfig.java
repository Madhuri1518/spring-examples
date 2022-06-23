package com.zemoso.spring_examples.config;

import com.zemoso.spring_examples.BaseballCoach;
import com.zemoso.spring_examples.Coach;
import com.zemoso.spring_examples.FortuneService;
import com.zemoso.spring_examples.HappyFortuneService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class BeanConfig {

    @Bean
    public FortuneService fortuneServiceBean() {
        return new HappyFortuneService();
    }

    @Bean
    public Coach baseballCoachBean(){
        return new BaseballCoach(fortuneServiceBean());
    }

    @Bean
    public SessionFactory sessionFactoryBean() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
}
