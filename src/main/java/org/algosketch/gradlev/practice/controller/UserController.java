package org.algosketch.gradlev.practice.controller;

import org.algosketch.gradlev.practice.domain.User;
import org.algosketch.gradlev.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/user/new")
    public String joinPage() {
        return "user/join";
    }

    @PostMapping("user/new")
    public String join(UserForm user) {
        User newUser = new User();
        newUser.setName(user.getName());
        userService.join(newUser);

        return "redirect:/";
    }

    @GetMapping("user")
    public String userList(Model model) {
        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        return "user/userList";
    }
}
