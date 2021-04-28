package com.by.petranovski.patterns.iterator.before_refactoring.service;

import com.by.petranovski.patterns.iterator.before_refactoring.bean.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class SteakHouseMenuService {

    private List<MenuItem> menuItemList = new ArrayList<>();

    public SteakHouseMenuService() {
        menuItemList.addAll(List.of(
                new MenuItem("fff", "fdsfsdsfs", true, 65.0),
                new MenuItem("bbb", "fdsasdadaffa", false, 19.0),
                new MenuItem("sfa", "fdweqeq", true, 92.0),
                new MenuItem("asa", "jhjkk", false, 5.0)
        ));
    }

    public List<MenuItem> getMenuItem() {
        return menuItemList;
    }

    public void addMenuItem(String name, String description, boolean vegetarian, double price) {
        menuItemList.add(new MenuItem(name, description, vegetarian, price));
    }
}
