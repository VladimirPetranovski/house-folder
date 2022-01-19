package com.by.petranovski.patterns.observer.my_observer_shop;

import java.util.ArrayList;
import java.util.List;

public class GoodsSite implements Observed{

    private List<String> goods = new ArrayList<>();

    private List<Custumer> customers = new ArrayList<>();

    public void addGoods(String goods) {
        this.goods.add(goods);
        notifyCustomer();
    }

    public void removeGoods(String goods) {
        this.goods.remove(goods);
        notifyCustomer();
    }

    @Override
    public void addCustomer(Custumer custumer) {
        this.customers.add(custumer);
    }

    @Override
    public void removeCustomer(Custumer custumer) {
        this.customers.remove(custumer);
    }

    @Override
    public void notifyCustomer() {
        for (Custumer customer : customers){
            customer.handleEvent(this.goods);
        }
    }
}
