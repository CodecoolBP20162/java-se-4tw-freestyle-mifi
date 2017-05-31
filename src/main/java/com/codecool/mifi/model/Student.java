package com.codecool.mifi.model;

/**
 * Created by marti on 2017.05.30..
 */
public class Student {

    private String name;
    private CcClass ccClass;
    private String gender;

    public Student(String name, String gender, CcClass ccClass) {
        this.name = name;
        this.gender = gender;
        this.ccClass = ccClass;
    }

    public String getName() {
        return name;
    }

    public CcClass getCcClass() {
        return ccClass;
    }

    public String getGender() {
        return gender;
    }
}
