package com.by.petranovski.patterns.builder.bean.builder_suleimanov;

public class App {

    public static void main(String[] args) {
        Director director = new Director();

        director.setWebsiteBuilder(new EnterpriseWebsiteBuilder());
        Website website = director.buildWebsite();

        System.out.println(website);
    }
}
