package com.by.petranovski.collections.map.howCreateMapFromRandomNumber;
/*
Так как ключи являются уникальными,
мы можем написать следующую программу -
сгенерируем набор случайных чисел сто раз и посчитаем количество повторов.
Map легко решит эту задачу - в качестве ключа используется сгенерированное
число, а в качестве значения - количество повторов.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenereteNumbersAndCountThemRepeat {
    Map<Integer, Integer> map = new HashMap<>();

    public Map<Integer, Integer> searchNumberCountByRandomNumber() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int number = random.nextInt(10);
            Integer frequency = map.get(number);
            map.put(number, frequency == null ? 1 : frequency + 1);
        }
        return map;
    }

}
