package com.by.petranovski.patterns.myObservable.view;

import com.by.petranovski.patterns.myObservable.interfaces.HttpRatesRequest;
import com.by.petranovski.patterns.myObservable.interfaces.Observer;
import com.by.petranovski.patterns.myObservable.interfaces.Subject;

public class SiteWidget implements InfoWidget, Observer {

    private double eur;

    private Subject webScrapper;

    public SiteWidget(Subject webScrapper) {
        this.webScrapper = webScrapper;
        webScrapper.registerObserver(this);
    }
    @Override
    public void update(HttpRatesRequest request) {
        this.eur = request.getEur();
        display();
    }

    public void display() {
        System.out.println("[SiteWidget.by... says...]eur -> " + eur);
    }

    public void observerRates() {
        webScrapper.registerObserver(this);
    }

    public void stopObserver() {
        webScrapper.removeObserver(this);
    }
}
