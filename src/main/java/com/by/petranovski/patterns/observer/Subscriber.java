package com.by.petranovski.patterns.observer;

import java.util.List;

public class Subscriber implements Observer{

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvents(List<String> vacancy) {
        System.out.println("Dear " + name + "\nWe have some vacancies: \n" + vacancy +
                "\n===============================================\n");
    }
}
