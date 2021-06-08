package com.by.petranovski.sql.myjdbc.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LightWeightUbUser {

    private Integer id;
    private String login;
    private String name;
    private Integer likes;
}
