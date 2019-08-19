package com.zlj.drools.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private String name;
    private int age;
    private String gender;
    private String birthplace;
    private Date birthday;
}
