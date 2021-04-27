package com.by.petranovski.patterns.builder.bean.builder_suleimanov;

public abstract class WebsiteBuilder {

    public Website website;

    public void createWebsite() {
        website = new Website();
    }

    public abstract void buildName();
    public abstract void buildCms();
    public abstract void buildPrice();

    public Website getWebsite() {
        return website;
    }
}
