package ru.jyfik.springtest.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.jyfik.springtest.webapp.domain.Role;
import ru.jyfik.springtest.webapp.domain.User;
import ru.jyfik.springtest.webapp.repos.UsersRepo;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UsersRepo usersRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addNewUser(User user, Model model) {
        User userFromDb = usersRepo.findByUserName(user.getUserName());

        if (userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRole(Collections.singleton(Role.USER));
        usersRepo.save(user);

        return "redirect:login";
    }
}
