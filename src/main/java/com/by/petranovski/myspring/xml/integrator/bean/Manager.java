package com.by.petranovski.myspring.xml.integrator.bean;

import lombok.Data;

import java.util.Set;

import static com.by.petranovski.patterns.iterator.before_refactoring.App.log;

@Data
public class Manager {

    private String name;
    private int age;
    private Set<Developer> developers;

    public Manager() {
        log.info(">>>>>>> Manager NoArgsConstructor call");
    }

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
