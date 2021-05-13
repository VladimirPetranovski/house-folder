package com.by.petranovski.patterns.jdkObservable.view;

import com.by.petranovski.patterns.jdkObservable.service.WebScrapper;

import java.util.Observable;
import java.util.Observer;

public class SiteWidget implements Observer {

    private double eur;

    public SiteWidget(Observable webScrapper) {
        webScrapper.addObserver(this);
    }

    @Override
    public void update(Observable webScrapper, Object args) {
        if (webScrapper instanceof WebScrapper) {
            WebScrapper webData = (WebScrapper) webScrapper;
            this.eur = webData.getEur();
            display();
        }
    }

    public void display() {
        System.out.println("[SiteWidget.by... says...]eur -> " + eur);
    }
}
