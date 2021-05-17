package com.by.petranovski.integrator.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class Manager {

    private String name;
    private int age;
    private Set<Developer> developers;

    public void setLevel(int i) {//кастыль

    }

    @Override
    public String toString() {
        return "\nManager{" +
                "name='" +name + "\'" +
                ", age=" + age +
                ", developers=" + developers +
                '}';
    }
}
