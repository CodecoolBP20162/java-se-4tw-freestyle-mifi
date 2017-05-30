package com.codecool.mifi.dao.Implementation;

import com.codecool.mifi.dao.StudentDao;
import com.codecool.mifi.model.CcClass;
import com.codecool.mifi.model.Student;

import java.util.List;
import java.util.Stack;

import static jdk.nashorn.internal.objects.NativeArray.pop;

/**
 * Created by marti on 2017.05.30..
 */
public class StudentDaoMem implements StudentDao {

    private Stack studentStack = new Stack();

    @Override
    public void add(Student student) {
        studentStack.push(student);
    }

    @Override
    public Student getLast() {
        return (Student) studentStack.pop();
    }

    @Override
    public Stack getAll() {
        return studentStack;
    }

}
