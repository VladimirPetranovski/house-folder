package com.by.petranovski.integrator.bean;

public class Developer {

    private String name;
    private String skill;
    private int level;
    private boolean isIntensive;

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
        return "Developer{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", level=" + level +
                ", isIntensive=" + isIntensive +
                '}';
    }
}
