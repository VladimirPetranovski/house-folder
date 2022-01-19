package com.by.petranovski.patterns.observer;

public class JobSearch {
    public static void main(String[] args) {
        JavaJobSiteWithVacancies jobsite = new JavaJobSiteWithVacancies();

        jobsite.addVacancy("First java position");
        jobsite.addVacancy("Second java position");

        Observer firstSubscriber = new Subscriber("Vladimir");
        Observer secondSubscriber = new Subscriber("Misha");

        jobsite.addObserver(firstSubscriber);
        jobsite.addObserver(secondSubscriber);

        jobsite.addVacancy("Third java position");

        jobsite.removeVacancy("First java position");

        jobsite.addVacancy("Fourth  java position");
    }
}
