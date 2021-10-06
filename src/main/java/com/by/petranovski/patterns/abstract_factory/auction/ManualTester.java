package com.by.petranovski.patterns.abstract_factory.auction;

import com.by.petranovski.patterns.abstract_factory.Tester;

public class ManualTester implements Tester {
    @Override
    public void testCode() {
        System.out.println("Manual tester tests application");
    }
}
