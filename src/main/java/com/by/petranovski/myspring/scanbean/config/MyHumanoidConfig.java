package com.by.petranovski.myspring.scanbean.config;

import com.by.petranovski.myspring.scanbean.bean.Head;
import com.by.petranovski.myspring.scanbean.bean.Human;
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
    public Head pavelHead() {
        Head head = new Head();
        head.setYears(3);
        return head;
    }



}
