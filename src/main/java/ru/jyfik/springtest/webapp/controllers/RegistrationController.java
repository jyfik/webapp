package ru.jyfik.springtest.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.jyfik.springtest.webapp.domain.Role;
import ru.jyfik.springtest.webapp.domain.User;
import ru.jyfik.springtest.webapp.repos.UsersRepo;

import java.sql.SQLException;
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
        if (user.getUserName().isEmpty() || user.getPassword().isEmpty()) {
            model.addAttribute("message", "You cannot create a user without" +
                                    " a Username or User password");
            return "registration";
        } else {

            user.setActive(true);
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(8)));
            user.setRole(Collections.singleton(Role.USER));
            usersRepo.save(user);

            return "redirect:login";
        }
    }
}
