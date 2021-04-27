package com.by.petranovski.patterns.builder.bean.e;

public class App {
    public static void main(String[] args) {
        Mather mather = new Mather();
        mather.setDogBuilder(new Tuzic());

        Dog dog = mather.buildDog();

        System.out.println(dog);
    }
}
