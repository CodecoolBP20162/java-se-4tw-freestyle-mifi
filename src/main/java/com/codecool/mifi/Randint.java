package com.codecool.mifi;

import com.codecool.mifi.controller.Controller;
import com.codecool.mifi.dao.Implementation.StudentDaoMem;
import com.codecool.mifi.model.CcClass;
import com.codecool.mifi.model.DateController;
import com.codecool.mifi.model.Student;
import com.codecool.mifi.model.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
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
public class Randint {

    public static void main(String[] args) throws FileNotFoundException {

        User user = new User("Liza","female");
        DateController date = new DateController(user);
        System.out.println(date.toString());

        TemplateEngine templateEngine = new ThymeleafTemplateEngine();

        // default server settings
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);

        get("/", Controller::renderPage, templateEngine);
        //get("/index", Controller::renderQuiz, templateEngine);

        get("/quiz",  Controller::renderQuiz, templateEngine);
        //get("/quizz",  Controller::renderQuiz, templateEngine);

        get("/quiz/user/:students",  Controller::renderQuiz, templateEngine);

        //get("/user/:name",  Controller::renderPage, templateEngine);

        get("/result",  Controller::renderResult, templateEngine);
        get("/result/:name",  Controller::renderResult, templateEngine);

        enableDebugScreen();
    }

}
