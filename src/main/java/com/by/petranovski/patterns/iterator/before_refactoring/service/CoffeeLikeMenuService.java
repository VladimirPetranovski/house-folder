package com.by.petranovski.patterns.iterator.before_refactoring.service;

import com.by.petranovski.patterns.iterator.before_refactoring.App;
import com.by.petranovski.patterns.iterator.before_refactoring.bean.MenuItem;


public class CoffeeLikeMenuService {

    private static final int MAX_ITEMS = 4;
    private MenuItem[] menuItems;
    private int numberOfItems = 0;

    public CoffeeLikeMenuService() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("fff", "fdsfsds", false, 3.0);
        addItem("sss", "fdsrgo", true, 17.0);
        addItem("ddf", "ljhds", false, 59.5);
        addItem("frrtyth", "uiter", true, 65.5);
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        if (numberOfItems >= MAX_ITEMS) {
            App.log.warn("No more item could be added to menu. Please remove one");
        }else {
            menuItems[numberOfItems] = new MenuItem(name, description, vegetarian, price);
            numberOfItems++;
        }
    }
}
