package com.by.petranovski.patterns.iterator.common_practic.bean;

import com.by.petranovski.patterns.iterator.common_practic.service.CoffeeLikeMenuService;
import com.by.petranovski.patterns.iterator.common_practic.service.SteakHouseMenuService;

import java.util.Iterator;
import java.util.List;

import static com.by.petranovski.patterns.iterator.common_practic.App.log;

public class VovaRestaurant {

    static CoffeeLikeMenuService coffeeLikeMenuService = new CoffeeLikeMenuService();
    static SteakHouseMenuService steakHouseMenuService = new SteakHouseMenuService();

    public static void printCommonMenu () {

        List<Iterable<MenuItem>> menus = List.of(coffeeLikeMenuService, steakHouseMenuService);
        menus.stream()
                .map(Iterable::iterator)
                .forEach(a -> print(a));
    }

    private static void print(Iterator<MenuItem> menu) {
        while (menu.hasNext()) {
            MenuItem result = menu.next();
            log.info(result.toString());
        }
    }
}
