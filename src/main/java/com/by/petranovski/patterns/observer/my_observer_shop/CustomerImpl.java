package com.by.petranovski.patterns.observer.my_observer_shop;

import java.util.List;

public class CustomerImpl implements Custumer{

    private String name;

    public CustomerImpl(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> goods) {
        System.out.println("Dear " + name + "\nWe have changes in goods:\n" + goods +
                "\n============================================================\n") ;
    }
}
