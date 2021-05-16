package com.by.petranovski.integrator.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BotProject {

    private String name;
    private Developer teamLead;
    private Date start;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeamLead(Developer teamLead) {
        this.teamLead = teamLead;
    }

}
