package com.by.petranovski.patterns.abstract_factory.banking;

import com.by.petranovski.patterns.abstract_factory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer is writing java code");
    }
}
