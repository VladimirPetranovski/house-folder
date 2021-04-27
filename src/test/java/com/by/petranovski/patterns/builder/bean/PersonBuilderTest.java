package com.by.petranovski.patterns.builder.bean;


import org.junit.Test;

public class PersonBuilderTest{

    @Test
    public void personBuilderUsage() {
        PersonBuilder personBuilder = new PersonBuilder();
        Person person = personBuilder.setName("Vasya")
                .setAge("13")
                .setLogin("login")
                .build();
    }

}