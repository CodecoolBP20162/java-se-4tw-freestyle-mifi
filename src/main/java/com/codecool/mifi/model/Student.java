package com.codecool.mifi.model;

/**
 * Created by marti on 2017.05.30..
 */
public class Student {

    private String name;
    private CcClass ccClass;

    public Student(String name, CcClass ccClass) {
        this.name = name;
        this.ccClass = ccClass;
    }

    public String getName() {
        return name;
    }

    public CcClass getCcClass() {
        return ccClass;
    }
}
