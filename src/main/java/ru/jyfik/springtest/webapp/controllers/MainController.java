package ru.jyfik.springtest.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.jyfik.springtest.webapp.domain.Message;
import ru.jyfik.springtest.webapp.repos.MessageRepo;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public ModelAndView greeting(ModelAndView model) {
        model.setViewName("hello");
        return model;
    }

    @GetMapping("/index")
    public ModelAndView sayHello() {
        Iterable<Message> messages = messageRepo.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("msg", messages);

        return modelAndView;
    }

    @PostMapping("/index")
    public String add(@RequestParam String text, @RequestParam String tag, Model model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("msg", messages);
        return "index";
    }

}
