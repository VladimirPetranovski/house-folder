package com.by.petranovski.patterns.strategy;

public class App {
    public static void main(String[] args) {
        var developer = new Developer();
        developer.setActivity(new Reading());
        developer.executeActivity();
    }


}
