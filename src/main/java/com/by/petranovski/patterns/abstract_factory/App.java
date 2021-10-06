package com.by.petranovski.patterns.abstract_factory;

import com.by.petranovski.patterns.abstract_factory.auction.AuctionTeamProject;
import com.by.petranovski.patterns.abstract_factory.banking.BankingTeamProject;

public class App {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new AuctionTeamProject();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        Manager manager = projectTeamFactory.getManager();

        developer.writeCode();
        tester.testCode();
        manager.manageProject();
    }
}
