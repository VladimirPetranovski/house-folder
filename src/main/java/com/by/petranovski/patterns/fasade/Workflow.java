package com.by.petranovski.patterns.fasade;

public class Workflow {
    Job job = new Job();
    Developer developer = new Developer();
    BugTracker bugTracker = new BugTracker();

    public void solveProblems() {
        job.doJob();
        bugTracker.startSprint();
        developer.doGobBeforeDeadline(bugTracker);
    }
}
