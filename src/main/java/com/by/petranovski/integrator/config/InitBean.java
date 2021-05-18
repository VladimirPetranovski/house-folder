package com.by.petranovski.integrator.config;

import org.springframework.beans.factory.InitializingBean;

import static com.by.petranovski.patterns.iterator.before_refactoring.App.log;

public class InitBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(">>>>>InitBean.afterPropertiesSet() was called");
    }
}
