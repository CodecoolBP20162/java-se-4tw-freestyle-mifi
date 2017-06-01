package com.codecool.mifi.model;

/**
 * Created by marti on 2017.05.30..
 */
public class Student {

    private String name;
    private CcClass ccClass;
    private String gender;
    private String picture;



    public Student(String name, String gender, CcClass ccClass, String picture) {
        this.name = name;
        this.gender = gender;
        this.ccClass = ccClass;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return name;
    }

    public CcClass getCcClass() {
        return ccClass;
    }

    public String getGender() {
        return gender;
    }
}
