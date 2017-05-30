package com.codecool.mifi.model;

/**
 * Created by marti on 2017.05.30..
 */
public class CcClass {

    private String location;
    private int classNum;

    public CcClass(String location, int classNum) {
        this.location = location;
        this.classNum = classNum;
    }

    private String getCCclass() {
        return location + Integer.toString(classNum);
    }

}
