package com.codecool.mifi.model;

/**
 * Created by marti on 2017.05.31..
 */
public class User {

    private final String name;
    private final String gender;

    public User(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}
