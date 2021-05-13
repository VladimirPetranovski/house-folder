package com.by.petranovski.patterns.jdkObservable;

import com.by.petranovski.patterns.jdkObservable.service.WebScrapper;
import com.by.petranovski.patterns.jdkObservable.view.InfoWidget;
import com.by.petranovski.patterns.jdkObservable.view.SiteWidget;
import com.by.petranovski.patterns.jdkObservable.view.WatchWidget;
import com.by.petranovski.patterns.jdkObservable.view.AndroidWidget;

public class App {
    public static void main(String[] args) {
        WebScrapper webScrapper = new WebScrapper();

        InfoWidget siteWidget = new SiteWidget(webScrapper);
        InfoWidget androidWidget = new AndroidWidget(webScrapper);
        InfoWidget watchWidget = new WatchWidget(webScrapper);

        webScrapper.getNewRates();
    }
}
