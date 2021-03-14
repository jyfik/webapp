package ru.jyfik.springtest.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, String> model) {
        model.put("name", name);
        return "hello";
    }

    @GetMapping
    public String sayHello() {
        return "index";
    }

}
