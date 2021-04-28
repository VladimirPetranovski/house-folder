package com.by.petranovski.patterns.iterator.before_refactoring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class MenuItem {

    private String name;
    private String description;
    private boolean vegetarian;
    private double price;
}
