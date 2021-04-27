package com.by.petranovski.patterns.builder.bean;

import org.junit.Test;

public class PersonWithLombokTest {

    @Test
    public void builder() {
        PersonWithLombok personWithLombok = PersonWithLombok.builder()
                .age("13")
                .name("va")
                .login("lo")
                .build();
        System.out.println(personWithLombok);
        personWithLombok.setAge("15");
        personWithLombok.setName("vo");
        personWithLombok.setLogin("login");
        System.out.println(personWithLombok);

    }

}