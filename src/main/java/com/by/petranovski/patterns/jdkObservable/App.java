package com.by.petranovski.patterns.jdkObservable;

import com.by.petranovski.patterns.jdkObservable.service.WebScrapper;
import com.by.petranovski.patterns.jdkObservable.view.InfoWidget;
import com.by.petranovski.patterns.jdkObservable.view.SiteWidget;
import com.by.petranovski.patterns.jdkObservable.view.WatchWidget;
import com.by.petranovski.patterns.jdkObservable.view.AndroidWidget;

public class App {
    public static void main(String[] args) throws InterruptedException {
        WebScrapper webScrapper = new WebScrapper();

        new SiteWidget(webScrapper);
        new AndroidWidget(webScrapper);
        new WatchWidget(webScrapper);

        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            webScrapper.getNewRates();
        }
    }
}
