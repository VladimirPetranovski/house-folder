package com.by.petranovski.patterns.builder.bean.e;

public class Dog {

    private String name;
    private Voice voice;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", voice=" + voice +
                ", age=" + age +
                '}';
    }
}
