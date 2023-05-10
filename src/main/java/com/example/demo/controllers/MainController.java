package com.example.demo.controllers;

import com.example.demo.services.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final UserModelService userModelService;

    @Autowired
    public MainController(UserModelService userModelService) {
        this.userModelService = userModelService;
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("users", userModelService.findAll());
        return "home";
    }
}
