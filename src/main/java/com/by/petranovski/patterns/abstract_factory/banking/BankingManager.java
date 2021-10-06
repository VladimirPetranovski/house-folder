package com.by.petranovski.patterns.abstract_factory.banking;

import com.by.petranovski.patterns.abstract_factory.Manager;

public class BankingManager implements Manager {
    @Override
    public void manageProject() {
        System.out.println("Bank's manager managers project");
    }
}
