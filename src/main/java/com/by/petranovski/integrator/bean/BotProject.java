package com.by.petranovski.integrator.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BotProject {

    private String name;
    private Developer teamLead;

    public void setName(String name) {
        this.name = name;
    }

    public void setTeamLead(Developer teamLead) {
        this.teamLead = teamLead;
    }

}
