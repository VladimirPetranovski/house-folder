package com.by.petranovski.patterns.observer.my_observer_shop;

public interface Observed {

    void addCustomer(Custumer custumer);

    void removeCustomer(Custumer custumer);

    void notifyCustomer();
}
