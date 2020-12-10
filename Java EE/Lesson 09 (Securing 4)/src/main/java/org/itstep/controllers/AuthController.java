package org.itstep.controllers;

import org.itstep.entities.Role;
import org.itstep.entities.User;
import org.itstep.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UsersRepository usersRepos;

    public AuthController(UsersRepository usersRepos) {
        this.usersRepos = usersRepos;
    }

    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    public String index() {
        return "auth/index";
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

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public String users(Model model) {
        model.addAttribute("users", usersRepos.findAll());
        return "auth/users";
    }
    @GetMapping("/user-edit/{user}")
    @PreAuthorize("hasRole('ADMIN')")
    public String userEdit(@PathVariable User user,
                           Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "auth/user-edit";
    }

    @PostMapping("/user-edit")
    @PreAuthorize("hasRole('ADMIN')")
    public String userEdit(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam Map<String, String> form,
                           @RequestParam("id") User user) {
        //очистка старых ролей
        user.getRoles().clear();

        //преобразования массива ролей в массив строк
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        usersRepos.save(user);
        return "redirect:/auth/users";
    }
}
