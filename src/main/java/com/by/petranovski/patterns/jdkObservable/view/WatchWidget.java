package com.by.petranovski.patterns.jdkObservable.view;

import com.by.petranovski.patterns.jdkObservable.service.WebScrapper;

import java.util.Observable;
import java.util.Observer;

public class WatchWidget implements Observer {

    private double usd;

    public WatchWidget(Observable webScrapper) {
        webScrapper.addObserver(this);
    }

    @Override
    public void update(Observable webScrapper, Object args) {
        if (webScrapper instanceof WebScrapper) {
            WebScrapper webData = (WebScrapper) webScrapper;
            this.usd = webData.getUsd();
            display();
        }
    }

    public void display() {
        System.out.println("[WatchWidget.by... says...]usd -> " + usd);
    }
}
