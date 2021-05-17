package com.by.petranovski.integrator.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Developer extends Contractor{

//    private String name;
    private String skill;
    private int level;
    private boolean isIntensive;
    private Map<String, Integer> techStack;

    public Developer(String name) {
        this.name = name;
    }

    public Developer(String name, String skill, int level, boolean isIntensive) {
        this.name = name;
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
