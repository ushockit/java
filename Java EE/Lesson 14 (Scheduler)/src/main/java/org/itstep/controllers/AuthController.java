package org.itstep.controllers;

import org.itstep.entities.Role;
import org.itstep.entities.User;
import org.itstep.repositories.UsersRepository;
import org.itstep.services.MailSenderService;
import org.itstep.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UsersService usersService;
    private final MailSenderService mailSenderService;

    public AuthController(UsersService usersService, MailSenderService mailSenderService) {
        this.usersService = usersService;
        this.mailSenderService = mailSenderService;
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
        User srchUser = this.usersService.findByUsername(user.getUsername());
        //пользователь существует
        if (srchUser != null) {
            model.put("message", "User exists");
            return "auth/registration";
        }

        if (this.usersService.addNewUser(user)) {

        }

        return "redirect:/auth/login";
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public String users(Model model) {
        model.addAttribute("users", this.usersService.findAll());
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

    @GetMapping("/activate/{code}")
    public String activate(@PathVariable("code") String code,
                           Model model) {
        boolean isActivated = this.usersService.activateUser(code);
        if (isActivated) {
            model.addAttribute("message", "Success activate");
        }
        else {
            model.addAttribute("message", "Error activated");
        }
        return "/auth/login";
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

        this.usersService.update(user);
        return "redirect:/auth/users";
    }
}
