package com.by.petranovski.myspring.scanbean.config;

import com.by.petranovski.myspring.scanbean.bean.Head;
import com.by.petranovski.myspring.scanbean.bean.Human;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyHumanoidConfig {

    @Bean
    @Scope("singleton")
    public Human pavel() {
        Human human = new Human();
        human.setName("Pavel");
        human.setWeight(76);
        return human;
    }

    @Bean
    @Scope("prototype")
    public Head head() {
        Head head = new Head();
        head.setYears(3);
        return head;
    }

    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger(MyHumanoidConfig.class);
    }



}
