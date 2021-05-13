package com.by.petranovski.patterns.myObservable.service;

import com.by.petranovski.patterns.myObservable.interfaces.HttpRatesRequest;
import com.by.petranovski.patterns.myObservable.interfaces.Observer;
import com.by.petranovski.patterns.myObservable.interfaces.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebScrapper implements Subject {

     private Set<Observer> observers = new HashSet<>();

    private double eur;
    private double usd;
    private double rus;

    @Override
    public void notifyObserver() {
        observers.forEach(o -> o.update(new HttpRatesRequest(eur, usd, rus)));
    }

    public void getNewRates() {
        this.eur = Math.round(ThreadLocalRandom.current().nextDouble(50, 100));
        this.usd = Math.round(ThreadLocalRandom.current().nextDouble(50, 100));
        this.rus = Math.round(ThreadLocalRandom.current().nextDouble(50, 100));

        this.ratesUpdate();
    }

    private void ratesUpdate() {
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
}
