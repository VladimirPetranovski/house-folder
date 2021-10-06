package com.by.petranovski.patterns.abstract_factory.auction;

import com.by.petranovski.patterns.abstract_factory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php developer is writing php code");
    }
}
