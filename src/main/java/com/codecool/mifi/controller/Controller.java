package com.codecool.mifi.controller;

import com.codecool.mifi.model.DateController;
import com.codecool.mifi.model.Heart;
import com.codecool.mifi.model.Student;
import com.codecool.mifi.model.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by sfanni on 5/30/17.
 */
public class Controller {

    private static String name;
    private static String gender;

    public static ModelAndView renderPage(Request req, Response res) throws FileNotFoundException {
        List<Student> students = DateController.getStudentList();
        Map<String, Object> params = new HashMap<>();
        params.put("students", students);
        return new ModelAndView(params, "index");
    }

    public static ModelAndView renderQuiz(Request req, Response res) {
        name =  req.queryParams("students");
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        System.out.println(name);
        return new ModelAndView(params, "quiz");
    }

    public static ModelAndView renderResult(Request req, Response res) throws FileNotFoundException {
        List<Student> students = DateController.getStudentList();
        for (Student student: students) {
            if (student.getName().equals(name)) {
                gender = student.getGender();
            }
        }
        User user = new User(name, gender);
        DateController date = new DateController(user);
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("time", date.getTime().toString());
        params.put("place", date.getPlace().toString());
        params.put("partner", date.getPartner().toString());
        params.put("picture", date.getPartner().getPicture());

        return new ModelAndView(params, "result");
    }


}
