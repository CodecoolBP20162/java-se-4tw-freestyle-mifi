package com.codecool.mifi.model;
/**
 * Created by marti on 2017.05.31..
 */

public class DateTime {

    private String dateTime;

    public DateTime(String dateTime) {
        this.dateTime = dateTime;

    }

    @Override
    public String toString() {
        return  dateTime;
    }
}
