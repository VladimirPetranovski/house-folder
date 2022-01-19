package com.by.petranovski.patterns.observer.my_observer_shop;

public class SearchGoods {
    public static void main(String[] args) {
        GoodsSite site = new GoodsSite();

        site.addGoods("First goods");
        site.addGoods("Second goods");
        site.addGoods("Third goods");

        Custumer customer = new CustomerImpl("Vladmir");
        Custumer customer1 = new CustomerImpl("Sania");
        Custumer customer2 = new CustomerImpl("Misha");

        site.addCustomer(customer);
        site.addCustomer(customer1);
        site.addCustomer(customer2);

        site.addGoods("Fourth goods");

        site.removeCustomer(customer1);
        site.removeGoods("First goods");
    }
}
