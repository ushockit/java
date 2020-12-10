package org.itstep.controllers;

import org.itstep.entities.Role;
import org.itstep.entities.User;
import org.itstep.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UsersRepository usersRepos;

    public AuthController(UsersRepository usersRepos) {
        this.usersRepos = usersRepos;
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registration(User user, Map<String, Object> model) {
        User srchUser = usersRepos.findUserByUsername(user.getUsername());
        //пользователь существует
        if (srchUser != null) {
            model.put("message", "User exists");
            return "auth/registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        usersRepos.save(user);

        return "redirect:/auth/login";
    }
}
