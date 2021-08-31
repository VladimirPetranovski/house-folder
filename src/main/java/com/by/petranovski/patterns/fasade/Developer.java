package com.by.petranovski.patterns.fasade;

public class Developer {
    public void doGobBeforeDeadline(BugTracker bugTracker) {
        if(bugTracker.isActiveSprint()) {
            System.out.println("Developer is solving problems");
        } else {
            System.out.println("Developer is reading Habrahabr...");
        }
    }
}
