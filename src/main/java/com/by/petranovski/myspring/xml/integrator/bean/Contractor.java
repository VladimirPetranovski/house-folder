package com.by.petranovski.myspring.xml.integrator.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Contractor {

    protected String name;
    private String number;
    private Date date;

    public void setLevel(int i) {
    }

    @Override
    public String toString() {
        return "\n\tContractor" + name + "{" +
                "number='" + number + '\'' +
                ", date=" + date +
                '}';
    }
}
