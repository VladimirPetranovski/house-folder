package com.by.petranovski.myspring.scanbean.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Human {

    private String name;
    private Integer weight;
    private Head head;

    public Human(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }
}

