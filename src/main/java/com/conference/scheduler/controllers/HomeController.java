package com.conference.scheduler.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @Value("${app.version}")
    private String version;

    @GetMapping("/")
    public Map home(){
        Map map = new HashMap<String, String>();
        map.put("app-version", version);
        return map;
    }
}
