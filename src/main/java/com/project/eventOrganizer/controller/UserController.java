package com.project.eventOrganizer.controller;

import com.project.eventOrganizer.service.UserService;
import com.project.eventOrganizer.view.UserView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/users/")
public class UserController {

    private final UserService service;

    @GetMapping("/add")
    public String getForm(Model model, UserView userView) {
        model.addAttribute("user", userView);
        return "user-add";
    }

    @PostMapping("/add")
    public String add(@Valid UserView userView) {
        service.add(userView);
        return "redirect:/users/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("users", service.findAll());
        return "user-list";
    }
}
