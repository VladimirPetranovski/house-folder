package com.by.petranovski.myspring.scanbean.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Head {

    private Integer years;

//    @Required
    @Autowired
    @Qualifier("head")
    public void setYears(@Value("9") Integer years) {
        this.years = years;
    }
}
