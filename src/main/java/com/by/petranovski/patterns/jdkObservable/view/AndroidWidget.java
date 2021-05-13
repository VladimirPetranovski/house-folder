package com.by.petranovski.patterns.jdkObservable.view;

import com.by.petranovski.patterns.jdkObservable.interfaces.HttpRatesRequest;
import com.by.petranovski.patterns.jdkObservable.interfaces.Observer;
import com.by.petranovski.patterns.jdkObservable.interfaces.Subject;

public class AndroidWidget implements InfoWidget, Observer {

    private double eur;
    private double usd;
    private double rus;

    private Subject webScrapper;

    public AndroidWidget(Subject webScrapper) {
        this.webScrapper = webScrapper;
        webScrapper.registerObserver(this);
    }

    @Override
    public void update(HttpRatesRequest request) {
        this.eur = request.getEur();
        this.usd = request.getUsd();
        this.rus = request.getRus();
        display();
    }

    public void display() {
        System.out.println("[AndroidWidget.by... says...]eur + usd + rus -> " + eur + " " + usd + " " + rus);
    }

    public void observerRates() {
        webScrapper.registerObserver(this);
    }

    public void stopObserver() {
        webScrapper.removeObserver(this);
    }
}
