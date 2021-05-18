package com.by.petranovski.integrator;

import com.by.petranovski.integrator.bean.Department;
import com.by.petranovski.integrator.bean.Developer;
import com.by.petranovski.integrator.bean.BotProject;
import com.by.petranovski.integrator.bean.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.util.Arrays;

public class IntegratorApp {

    private static final Logger log = LoggerFactory.getLogger(IntegratorApp.class);

    public static void main(String[] args) throws ParseException {
//        baseSyntax();
//        composition();
//        singletonVsPrototype();
//        printContext();
//        contextCounties();
//        useFabricMethod();
//        useCollectionAndInheritance();
        beanLifeCycle();
    }

    private static void beanLifeCycle() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        Department department = ctx.getBean("israel", Department.class);
        log.info("Department = {}", department);
    }
    private static void useCollectionAndInheritance() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

        Manager manager = ctx.getBean("manager", Manager.class);
        log.info("Managet = {}", manager);
    }

    private static void useFabricMethod() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

        BotProject botProject = ctx.getBean("yoga", BotProject.class);
        BotProject botProject2 = ctx.getBean("fitness", BotProject.class);
        log.info("date = {}", botProject);
        log.info("date2 = {}", botProject2 );
    }

    private static void contextCounties() {

        ApplicationContext firstCtx = new ClassPathXmlApplicationContext("context.xml");
        ApplicationContext secondCtx = new ClassPathXmlApplicationContext("context.xml");

        BotProject yoga = firstCtx.getBean("yoga", BotProject.class);
        log.info("yoga = {}", yoga);

        yoga.setName("Scope changing demonstration");

        BotProject newYoga = secondCtx.getBean("yoga", BotProject.class);
        log.info("newYoga = {}", newYoga);

        log.info("are equal {}", ((yoga == newYoga)));
    }

    private static void printContext() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        Arrays.stream(ctx.getBeanDefinitionNames())
                .forEach(a -> log.info(a));
    }

    private static void singletonVsPrototype() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        BotProject fitnessBotProject = ctx.getBean("fitness", BotProject.class);//можно обращаться через  или name
        BotProject yogaBotProject = ctx.getBean("yoga", BotProject.class);
        log.info("{}", fitnessBotProject);
        log.info("{}", yogaBotProject);
    }

    private static void baseSyntax() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        Developer developer = (Developer) ctx.getBean("dev");
        Developer trainee = ctx.getBean("trainee", Developer.class);

        log.info("{}", developer);
        log.info("{}", trainee);
    }
}
