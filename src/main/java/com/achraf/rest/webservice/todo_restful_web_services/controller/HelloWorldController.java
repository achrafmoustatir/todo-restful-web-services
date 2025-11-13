package com.achraf.rest.webservice.todo_restful_web_services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorldController {


    @GetMapping("/hello-world/{name}")
    public Map<String, String> sayHello(@PathVariable  String name) {
        //throw new RuntimeException("Not Implemented");
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello " + name);
        return response;

    }
}
