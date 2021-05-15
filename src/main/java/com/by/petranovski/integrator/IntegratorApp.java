package com.by.petranovski.integrator;

import com.by.petranovski.integrator.bean.Developer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntegratorApp {

    private static final Logger log = LoggerFactory.getLogger(IntegratorApp.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        Developer developer = (Developer) ctx.getBean("dev");

        log.info("{}", developer.toString());
    }
}
