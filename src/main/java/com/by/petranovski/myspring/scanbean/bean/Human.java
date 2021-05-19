package com.by.petranovski.myspring.scanbean.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Human {

    private String name;
    private Integer weight;

    @Autowired
    @Qualifier("head")
    private Head head;

//    @Autowired
//    private Logger logger;

    public Human(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }
}

