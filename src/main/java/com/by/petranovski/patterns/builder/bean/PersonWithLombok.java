package com.by.petranovski.patterns.builder.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonWithLombok {

    private String name;
    private String age;
    private String login;
}
