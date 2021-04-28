package com.by.petranovski.patterns.iterator.before_refactoring.bean;

import com.by.petranovski.patterns.iterator.before_refactoring.App;

import java.util.List;

public class VovaRestaurant {

    static CoffeeLike coffeeLike = new CoffeeLike();
    static SteakHouse steakHouse = new SteakHouse();

    public static void printCommonMenu () {
        MenuItem[] coffeeLikeMenu = coffeeLike.coffeeLikeMenuService.getMenuItems();
        List<MenuItem> steakHouseMenu = steakHouse.steakHouseMenuService.getMenuItemList();

        for (int i = 0; i < coffeeLikeMenu.length; i++) {
            App.log.info(coffeeLikeMenu[i].toString());
        }

        for (int i = 0; i < steakHouseMenu.size(); i++) {
            App.log.info(steakHouseMenu.get(i).toString());
        }
    }
}
