package com.codecool.mifi;

import com.codecool.mifi.controller.Controller;
import com.codecool.mifi.dao.Implementation.StudentDaoMem;
import com.codecool.mifi.model.CcClass;
import com.codecool.mifi.model.Student;
import spark.TemplateEngine;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * Created by sfanni on 5/30/17.
 */
public class Date {

    public static void main(String[] args) throws FileNotFoundException {

        StudentDaoMem studentDaoMem = new StudentDaoMem();
        Stack students = generateStack(populateData(),studentDaoMem);
        for (Object student : students) {
            student = (Student) student;
            System.out.println(((Student) student).getName());
        }

        TemplateEngine templateEngine = new ThymeleafTemplateEngine();

        // default server settings
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);

        get("/", Controller::renderPage, templateEngine);

        enableDebugScreen();
    }

    private static String read(String filePath) throws FileNotFoundException {
        String content = new Scanner(new File(filePath)).useDelimiter("\\Z").next();
        return content;
    }

    private static List<Student> populateData() throws FileNotFoundException {
        List<Student> studentList = new ArrayList<>();
        String lines = read("/home/marti/Codecool/java-se-4tw-freestyle-mifi/src/main/resources/Students.csv");
        String[] splitLines = lines.split("\n");
        for (String student : splitLines) {
            studentList.add(new Student(student,new CcClass("Budapest",2)));
        }
        return studentList;
    }

    private static Stack generateStack(List<Student> studentList, StudentDaoMem studentDaoMem) {
        Random random = new Random();
        List<Integer> randomIndexList = new ArrayList<>();
        int counter = 0;
        while (counter < studentList.size()-1) {
            int randomIndex = random.nextInt(studentList.size());
            if (!randomIndexList.contains(randomIndex)) {
                randomIndexList.add(randomIndex);
                studentDaoMem.add(studentList.get(randomIndex));
                counter++;
            }else {
                continue;
            }
        }
        return studentDaoMem.getAll();
    }

}
