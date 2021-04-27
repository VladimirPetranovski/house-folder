package com.by.petranovski.patterns.builder.bean.builder_suleimanov;

public class EnterpriseWebsiteBuilder extends WebsiteBuilder{
    @Override
    public void buildName() {
        website.setName("Enterprise website");
    }

    @Override
    public void buildCms() {
        website.setCms(Cms.ALIFRESCO);
    }

    @Override
    public void buildPrice() {
        website.setPrice(10000);
    }
}
