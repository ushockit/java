package org.itstep.controllers;

import org.itstep.entities.Role;
import org.itstep.entities.User;
import org.itstep.repositories.UsersRepository;
import org.itstep.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UsersRepository usersRepos;

    private final UsersService usersService;

    public AuthController(UsersRepository usersRepos, UsersService usersService) {
        this.usersRepos = usersRepos;
        this.usersService = usersService;
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
    public String registration(@Valid User user,
                               BindingResult result,
                               Model model) {

        //есть ошибки валидация
        if (result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(fieldError -> fieldError.getField() + "Error", FieldError::getDefaultMessage));
            //ключи в переменные
            model.mergeAttributes(errors);
            model.addAttribute("login", user.getUsername());

            return "auth/registration";
        }

        User srchUser = usersRepos.findUserByUsername(user.getUsername());
        //пользователь существует
        if (srchUser != null) {
            model.addAttribute("message", "User exists");
            return "auth/registration";
        }

        this.usersService.registrationUser(user);

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
