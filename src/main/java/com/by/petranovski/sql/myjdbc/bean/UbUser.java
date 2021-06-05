package com.by.petranovski.sql.myjdbc.bean;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class UbUser {

    private Integer id;
    private String login;
    private String name;
    private String bio;
//    private Byte[] image;
    private LocalDate birth;
    private LocalDateTime registered;
    private LocalDateTime updated;
    private Character gender;
    private Integer likes;
    private Double credit;
    private Boolean active;
}
