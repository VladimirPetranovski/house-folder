package com.by.petranovski.patterns.jdkObservable.view;

import com.by.petranovski.patterns.jdkObservable.interfaces.Observer;
import com.by.petranovski.patterns.jdkObservable.interfaces.Subject;
import com.by.petranovski.patterns.jdkObservable.interfaces.HttpRatesRequest;

public class WatchWidget implements InfoWidget, Observer {

    private double usd;

    private Subject webScrapper;

    public WatchWidget(Subject webScrapper) {
        this.webScrapper = webScrapper;
        webScrapper.registerObserver(this);
    }

    @Override
    public void update(HttpRatesRequest request) {
        this.usd = request.getUsd();
        display();
    }

    public void display() {
        System.out.println("[WatchWidget.by... says...]usd -> " + usd);
    }

    public void observerRates() {
        webScrapper.registerObserver(this);
    }

    public void stopObserver() {
        webScrapper.removeObserver(this);
    }
}
