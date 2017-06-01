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

    public static ModelAndView renderPage(Request req, Response res) throws FileNotFoundException {
//        List<Heart> hearts = new ArrayList<>();
//        hearts.add(new Heart("purple", 2));
//        hearts.add(new Heart("pink", 5));
//        Map<String, Object> params = new HashMap<>();
//        params.put("hearts", hearts);
        //String name = req.params(":name");
        //req.session().attribute("name", name);
        String name = req.params("students");
        System.out.println(name);
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
        //User user = new User();
        //DateController date = new DateController(user);
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return new ModelAndView(params, "result");
    }


}
