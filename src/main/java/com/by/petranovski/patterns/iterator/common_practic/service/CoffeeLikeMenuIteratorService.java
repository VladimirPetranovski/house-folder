package com.by.petranovski.patterns.iterator.common_practic.service;

import com.by.petranovski.patterns.iterator.common_practic.bean.MenuItem;

import java.util.Iterator;

public class CoffeeLikeMenuIteratorService implements Iterator<MenuItem> {

    private MenuItem[] menuItems;
    private int position = 0;

    public CoffeeLikeMenuIteratorService(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if(menuItems == null || position >= menuItems.length || menuItems[position] == null) {
            return false;
        }
        return true;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems[position];
        position++;
        return menuItem;
    }
}
