package com.by.petranovski.patterns.iterator.refactoring.bean;

import com.by.petranovski.patterns.iterator.refactoring.App;
import com.by.petranovski.patterns.iterator.refactoring.service.CoffeeLikeMenuService;
import com.by.petranovski.patterns.iterator.refactoring.service.Iterable;
import com.by.petranovski.patterns.iterator.refactoring.service.SteakHouseMenuService;

import java.util.List;

import static com.by.petranovski.patterns.iterator.refactoring.App.*;

public class VovaRestaurant {

    static CoffeeLikeMenuService coffeeLikeMenuService = new CoffeeLikeMenuService();
    static SteakHouseMenuService steakHouseMenuService = new SteakHouseMenuService();

    public static void printCommonMenu () {
        Iterator coffeeLikeMenu = coffeeLikeMenuService.getMenuIterator();
        Iterator steakHouseMenu = steakHouseMenuService.getMenuIterator();

        print(coffeeLikeMenu);
        print(steakHouseMenu);
    }

    private static void print(Iterator<MenuItem> menu) {
        while (menu.hasNext()) {
            MenuItem result = menu.next();
            log.info(result.toString());
        }
    }
}
