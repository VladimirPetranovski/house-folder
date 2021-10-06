package com.by.petranovski.patterns.abstract_factory.auction;

import com.by.petranovski.patterns.abstract_factory.Manager;

public class AuctionManager implements Manager {
    @Override
    public void manageProject() {
        System.out.println("Manager managers auction project");
    }
}
