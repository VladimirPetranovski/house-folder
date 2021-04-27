package com.by.petranovski.patterns.builder.myhuman;

import org.junit.Test;

public class HumanTest{

    @Test
    public void builderTest() {
        Human human = Human.builder()
                .setName("gkjgj")
                .setAge("3")
                .setId(1)
                .build();
        System.out.println(human.toString());
    }

}