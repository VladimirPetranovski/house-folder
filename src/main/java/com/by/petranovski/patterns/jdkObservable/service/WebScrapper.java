package com.by.petranovski.patterns.jdkObservable.service;

import com.by.petranovski.patterns.jdkObservable.interfaces.HttpRatesRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebScrapper extends Observable {

    private double eur;
    private double usd;
    private double rus;

    public void getNewRates() {
        this.eur = Math.round(ThreadLocalRandom.current().nextDouble(50, 100));
        this.usd = Math.round(ThreadLocalRandom.current().nextDouble(50, 100));
        this.rus = Math.round(ThreadLocalRandom.current().nextDouble(50, 100));

        this.ratesUpdate();
    }

    private void ratesUpdate() {
        setChanged();
        notifyObservers();
    }

}
