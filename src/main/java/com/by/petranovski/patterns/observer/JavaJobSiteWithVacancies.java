package com.by.petranovski.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class JavaJobSiteWithVacancies implements Observed{

    private List<String> vacancies = new ArrayList<>();

    private List<Observer> subscribers = new ArrayList<>();

    public void addVacancy(String vacancy) {
        this.vacancies.add(vacancy);
        notifyObservers();
    }

    public void removeVacancy(String vacancy) {
        this.vacancies.remove(vacancy);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : subscribers) {
            observer.handleEvents(vacancies);
        }
    }
}
