package com.by.petranovski.patterns.abstract_factory.auction;

import com.by.petranovski.patterns.abstract_factory.Developer;
import com.by.petranovski.patterns.abstract_factory.Manager;
import com.by.petranovski.patterns.abstract_factory.ProjectTeamFactory;
import com.by.petranovski.patterns.abstract_factory.Tester;

public class AuctionTeamProject implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public Manager getManager() {
        return new AuctionManager();
    }
}
