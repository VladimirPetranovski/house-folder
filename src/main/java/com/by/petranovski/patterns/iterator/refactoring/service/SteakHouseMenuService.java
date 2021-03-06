package com.by.petranovski.patterns.iterator.refactoring.service;

import com.by.petranovski.patterns.iterator.refactoring.bean.Iterator;
import com.by.petranovski.patterns.iterator.refactoring.bean.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class SteakHouseMenuService implements Iterable<MenuItem>{

    private List<MenuItem> menuItemList = new ArrayList<>();

    public SteakHouseMenuService() {
        menuItemList.addAll(List.of(
                new MenuItem("fff", "fdsfsdsfs", true, 65.0),
                new MenuItem("bbb", "fdsasdadaffa", false, 19.0),
                new MenuItem("sfa", "fdweqeq", true, 92.0),
                new MenuItem("asa", "jhjkk", false, 5.0)
        ));
    }

    public List<com.by.petranovski.patterns.iterator.refactoring.bean.MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void addMenuItem(String name, String description, boolean vegetarian, double price) {
        menuItemList.add(new MenuItem(name, description, vegetarian, price));
    }

    @Override
    public Iterator<MenuItem> getMenuIterator() {
        return new SteakHouseMenuIteratorService(menuItemList);
    }
}
