package com.by.petranovski.integrator;

import com.by.petranovski.integrator.bean.Developer;
import com.by.petranovski.integrator.bean.BotProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class IntegratorApp {

    private static final Logger log = LoggerFactory.getLogger(IntegratorApp.class);

    public static void main(String[] args) {
//        baseSyntax();
//        composition();
//        singletonVsPrototype();
//        printContext();
    }

    private static void contextCounties() {

    }

    private static void printContext() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        Arrays.stream(ctx.getBeanDefinitionNames())
                .forEach(a -> log.info(a));
    }

    private static void singletonVsPrototype() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");

        BotProject project = ctx.getBean("projectA", BotProject.class);
        log.info("project = {}", project);

        project.setName("Scope changing demonstration");

        BotProject fitness = ctx.getBean("projectA", BotProject.class);
        log.info("fitness = {}", fitness);

        BotProject yoga = ctx.getBean("projectA", BotProject.class);
        log.info("yoga = {}", yoga);

        log.info("are equal {}", ((project == fitness)
                && (fitness == yoga) && (project == yoga)));
    }

    private static void composition() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        BotProject fitnessBotProject = ctx.getBean("fitness", BotProject.class);//можно обращаться через  или name
        BotProject yogaBotProject = ctx.getBean("yoga", BotProject.class);
        log.info("{}", fitnessBotProject);
        log.info("{}", yogaBotProject);
    }

    private static void baseSyntax() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        Developer developer = (Developer) ctx.getBean("dev");
        Developer trainee = ctx.getBean("trainee", Developer.class);

        log.info("{}", developer);
        log.info("{}", trainee);
    }
}
