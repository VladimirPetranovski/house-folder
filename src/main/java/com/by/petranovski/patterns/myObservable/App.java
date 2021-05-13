package com.by.petranovski.patterns.myObservable;

import com.by.petranovski.patterns.myObservable.service.WebScrapper;
import com.by.petranovski.patterns.myObservable.view.AndroidWidget;
import com.by.petranovski.patterns.myObservable.view.InfoWidget;
import com.by.petranovski.patterns.myObservable.view.SiteWidget;
import com.by.petranovski.patterns.myObservable.view.WatchWidget;

public class App {
    public static void main(String[] args) {
        WebScrapper webScrapper = new WebScrapper();

        InfoWidget siteWidget = new SiteWidget(webScrapper);
        InfoWidget androidWidget = new AndroidWidget(webScrapper);
        InfoWidget watchWidget = new WatchWidget(webScrapper);

        webScrapper.getNewRates();
    }
}
