package com.by.petranovski.collections.map.how_change_parametrs_place;
/*
Напишите метод, который получает на вход Map<K, V> и возвращает Map,
где ключи и значения поменяны местами. Так как значения могут совпадать,
то тип значения в Map будет уже не K, а Collection<K>:
 */

import java.util.*;

public class ChangeParametrsPlace {

    public static <K, V> Map<V, Collection<K>> inverse(Map<? extends K, ? extends V> map){
        Map<V, Collection<K>> resultMap = new HashMap<>();

        Set<K> keys = (Set<K>) map.keySet();
        for(K key : keys){
            V value = map.get(key);
            resultMap.compute(value, (v, ks) -> {
                if(ks == null){
                    ks = new HashSet<>();
                }
                ks.add(key);
                return ks;
            });
        }
        return resultMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("kjlhl", 3);
        System.out.println(inverse(map));
    }
}
