package com.by.petranovski.patterns.iterator.refactoring.service;

import com.by.petranovski.patterns.iterator.refactoring.bean.Iterator;
import com.by.petranovski.patterns.iterator.refactoring.bean.MenuItem;

import java.util.List;

public class SteakHouseMenuIteratorService implements Iterator<MenuItem> {

    private List<MenuItem> menuItemsList;
    private int position = 0;

    public SteakHouseMenuIteratorService(List<MenuItem> menuItemsList) {
        this.menuItemsList = menuItemsList;
    }

    @Override
    public boolean hasNext() {
        if(menuItemsList == null || position >= menuItemsList.size() || menuItemsList.get(position) == null) {
            return false;
        }
        return true;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItemsList.get(position);
        position++;
        return menuItem;
    }
}
