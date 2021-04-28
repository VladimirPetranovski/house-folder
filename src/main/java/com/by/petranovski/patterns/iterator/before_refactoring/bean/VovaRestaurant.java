package com.by.petranovski.patterns.iterator.before_refactoring.bean;

import java.util.List;

public class VovaRestaurant {

    private CoffeeLike coffeeLike;
    private SteakHouse steakHouse;

    public void printCommonMenu () {
        MenuItem[] coffeeLikeMenu = coffeeLike.coffeeLikeMenuService.getMenuItems();
        List<MenuItem> steakHouseMenu = steakHouse.steakHouseMenuService.getMenuItem();
    }
}
