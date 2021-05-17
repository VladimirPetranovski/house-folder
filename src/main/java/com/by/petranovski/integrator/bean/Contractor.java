package com.by.petranovski.integrator.bean;

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

    private String number;
    private Date date;

    @Override
    public String toString() {
        return "\n\tContractor{" +
                "number='" + number + '\'' +
                ", date=" + date +
                '}';
    }
}
