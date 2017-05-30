package com.codecool.mifi.controller;

import com.codecool.mifi.model.Heart;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sfanni on 5/30/17.
 */
public class Controller {

    public static ModelAndView renderPage(Request req, Response res) {
        List<Heart> hearts = new ArrayList<>();
        hearts.add(new Heart("purple", 2));
        hearts.add(new Heart("pink", 5));
        Map<String, Object> params = new HashMap<>();
        params.put("hearts", hearts);
        return new ModelAndView(params, "index");
    }
}
