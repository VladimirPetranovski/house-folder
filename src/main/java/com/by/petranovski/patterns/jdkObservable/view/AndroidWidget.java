package com.by.petranovski.patterns.jdkObservable.view;

import com.by.petranovski.patterns.jdkObservable.service.WebScrapper;

import java.util.Observable;
import java.util.Observer;

public class AndroidWidget implements Observer {

    private double eur;
    private double usd;
    private double rus;

    public AndroidWidget(Observable webScrapper) {
        webScrapper.addObserver(this);
    }

    @Override
    public void update(Observable webScrapper, Object args) {
        if (webScrapper instanceof WebScrapper) {
            WebScrapper webData = (WebScrapper) webScrapper;
            this.eur = webData.getEur();
            this.usd = webData.getUsd();
            this.rus = webData.getRus();
            display();
        }
    }

    public void display() {
        System.out.println("[AndroidWidget.by... says...]eur + usd + rus -> " + eur + " " + usd + " " + rus);
    }
}
