package com.by.petranovski.integrator.bean;

public class Developer {

    private String name;
    private String skill;
    private int level;
    private boolean isIntensive;

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
