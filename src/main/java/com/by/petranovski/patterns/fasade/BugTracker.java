package com.by.petranovski.patterns.fasade;

public class BugTracker {
    private boolean activeSprint;

    public boolean isActiveSprint() {
        return activeSprint;
    }

    public void startSprint() {
        System.out.println("Sprint is active...");
        activeSprint = true;
    }

    public void stopSprint() {
        System.out.println("Sprint no active...");
        activeSprint =false;
    }
}
