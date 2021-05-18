package com.by.petranovski.myspring.xml.integrator.bean;

import lombok.Data;

import java.util.Map;

import static com.by.petranovski.patterns.iterator.before_refactoring.App.log;

@Data
public class Developer extends Contractor{

//    private String name;
    private String skill;
    private int level;
    private boolean isIntensive;
    private Map<String, Integer> techStack;

    public Developer() {
        log.info(">>>>>>> Developer NoArgsConstructor call");
    }

    public Developer(String name) {
        this.name = name;
    }

    public Developer(String skill, int level, boolean isIntensive, Map<String, Integer> techStack) {
        log.info(">>>>>>> Developer AllArgsConstructor call");
        this.skill = skill;
        this.level = level;
        this.isIntensive = isIntensive;
        this.techStack = techStack;
        log.info(">>>>>>> Developer AllArgsConstructor complete");
    }

    public Developer(String skill, int level, boolean inIntensive) {
        this.skill = skill;
        this.level = level;
        this.isIntensive = isIntensive;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\t\tDeveloper{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", level=" + level +
                ", isIntensive=" + isIntensive +
                "," + "\n\t\t\t\t" +
                "techStack=" + techStack +
                '}';
    }
}
