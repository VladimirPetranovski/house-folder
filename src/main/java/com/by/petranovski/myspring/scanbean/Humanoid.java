package com.by.petranovski.myspring.scanbean;

import com.by.petranovski.myspring.scanbean.bean.Human;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Humanoid {

    private static final Logger log = LoggerFactory.getLogger(Humanoid.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("humanoid.xml");
        Human human = context.getBean(Human.class);
        log.info("human = {}", human);
    }
}
