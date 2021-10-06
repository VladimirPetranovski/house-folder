package com.by.petranovski.patterns.abstract_factory.banking;

import com.by.petranovski.patterns.abstract_factory.Developer;
import com.by.petranovski.patterns.abstract_factory.Manager;
import com.by.petranovski.patterns.abstract_factory.ProjectTeamFactory;
import com.by.petranovski.patterns.abstract_factory.Tester;

public class BankingTeamProject implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QaTester();
    }

    @Override
    public Manager getManager() {
        return new BankingManager();
    }
}
