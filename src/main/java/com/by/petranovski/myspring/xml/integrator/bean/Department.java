package com.by.petranovski.myspring.xml.integrator.bean;

import lombok.Data;

import java.util.List;

import static com.by.petranovski.patterns.iterator.before_refactoring.App.log;
@Data
public class Department {

    private String name;
    private List<?> team;

    public Department() {
        log.info(">>>>>>> Department NoArgsConstructor call");
    }

    public Department(String name, List<?> team) {
        log.info(">>>>>>> Department AllArgsConstructor call");
        this.name = name;
        this.team = team;
        log.info(">>>>>>> Department AllArgsConstructor completed");
    }

    private void initDepartment() {
        log.info(">>>>>>> initDepartment call");
        log.info(">>>>>>> total devs" + team.size());
        log.info(">>>>>>> initDepartment complete");
    }

    @Override
    public String toString() {
        log.info(">>>>>>> Department toString call");
        return "Department{" +
                "name='" + name + '\'' +
                ", team=" + team +
                '}';
    }

}
