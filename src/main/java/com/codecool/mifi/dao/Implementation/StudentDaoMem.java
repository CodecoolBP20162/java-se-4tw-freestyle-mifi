package com.codecool.mifi.dao.Implementation;

import com.codecool.mifi.dao.StudentDao;
import com.codecool.mifi.model.CcClass;
import com.codecool.mifi.model.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static jdk.nashorn.internal.objects.NativeArray.pop;

/**
 * Created by marti on 2017.05.30..
 */
public class StudentDaoMem implements StudentDao {

    private Stack maleStack = new Stack();
    private Stack femaleStack = new Stack();

    @Override
    public void add(Student student, Stack stack) {
        stack.push(student);
    }

    @Override
    public Student getLast(Stack stack) {
        return (Student) stack.pop();
    }

    @Override
    public Stack getAll(String gender) {
        if (gender.equals("female")) {
            return femaleStack;
        } else {
            return maleStack;
        }
    }

}
