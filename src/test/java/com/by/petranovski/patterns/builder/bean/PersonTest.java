package com.by.petranovski.patterns.builder.bean;

import org.junit.Test;

public class PersonTest {

    @Test
    public void setReturnObject() {
//        Person person = new Person();
//        person.setAge("12")
//                .setName("Vasya")
//                .setLogin("Login");
//        System.out.println(person);
    }

    @Test
    public void builderFirstGen() {
//        Person person = new Person();
//        person = person.new PersonBuilder()
//                .setAge("12")
//                .setLogin("lo")
//                .setName("Vasya")
//                .build();
    }

    @Test
    public void builderSecondGen() {
        Person person = new Person.PersonBuilder()
                .setAge("12")
                .setLogin("lo")
                .setName("Vasya")
                .build();
    }

    @Test
    public void builderThirdGen() {
        Person person = Person.builder()
                .setAge("12")
                .setLogin("lo")
                .setName("Vasya")
                .build();
    }

}