package com.by.petranovski.patterns.iterator.refactoring.service;

import com.by.petranovski.patterns.iterator.refactoring.bean.Iterator;
import com.by.petranovski.patterns.iterator.refactoring.bean.MenuItem;

import java.awt.*;

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
