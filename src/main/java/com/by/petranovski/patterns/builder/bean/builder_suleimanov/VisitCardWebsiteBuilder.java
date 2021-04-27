package com.by.petranovski.patterns.builder.bean.builder_suleimanov;

public class VisitCardWebsiteBuilder extends WebsiteBuilder{
    @Override
    public void buildName() {
        website.setName("Visit Card");
    }

    @Override
    public void buildCms() {
         website.setCms(Cms.WORDPRESS);
    }

    @Override
    public void buildPrice() {
        website.setPrice(500);
    }
}
