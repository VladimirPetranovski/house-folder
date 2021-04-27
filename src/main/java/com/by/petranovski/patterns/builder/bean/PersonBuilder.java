package com.by.petranovski.patterns.builder.bean;

public class PersonBuilder {

    private String name;
    private String age;
    private String login;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setAge(String age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setLogin(String login) {
        this.login = login;
        return this;
    }

    public Person build() {
        return new Person(name, age, login);
    }
}
