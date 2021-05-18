package com.by.petranovski.myspring.scanbean.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Head {

    private Integer years;

//    @Required
//    @Autowired
    public void setYears(Integer years) {   //(@Value("9") Integer years) можно засэтать дэфолтное значение = 9
        this.years = years;
    }
}
