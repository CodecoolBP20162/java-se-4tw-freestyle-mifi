package com.codecool.mifi;

import com.codecool.mifi.controller.Controller;
import spark.TemplateEngine;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * Created by sfanni on 5/30/17.
 */
public class Main {

    public static void main(String[] args) {


        TemplateEngine templateEngine = new ThymeleafTemplateEngine();

        // default server settings
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);

        get("/", Controller::renderPage, templateEngine);

        enableDebugScreen();
    }
}
