package com.by.petranovski.patterns.builder.bean.builder_suleimanov;

public class Director {

    private WebsiteBuilder websiteBuilder;

    public void setWebsiteBuilder(WebsiteBuilder websiteBuilder) {
        this.websiteBuilder = websiteBuilder;
    }

    public Website buildWebsite() {
        websiteBuilder.createWebsite();
        websiteBuilder.buildName();
        websiteBuilder.buildCms();
        websiteBuilder.buildPrice();

        Website website = websiteBuilder.getWebsite();

        return website;
    }

}
