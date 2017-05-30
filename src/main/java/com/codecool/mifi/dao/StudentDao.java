package com.codecool.mifi.dao;

import com.codecool.mifi.model.Student;

import java.util.List;
import java.util.Stack;


/**
 * Created by marti on 2017.05.30..
 */
public interface StudentDao {

    void add(Student student);

    Student getLast();

    Stack getAll();

}
