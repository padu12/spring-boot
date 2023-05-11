package com.example.demo.controllers;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final UserModelService userModelService;

    @Autowired
    public MainController(UserModelService userModelService) {
        this.userModelService = userModelService;
    }

    @GetMapping("/home")
    public String home(Model model, @ModelAttribute("newUser") UserModel usermodel){
        model.addAttribute("users", userModelService.findAll());
        return "home";
    }

    @PostMapping("/create1")
    public String newRecord(@ModelAttribute("newUser") UserModel userModel) {
        userModelService.save(userModel);
        return "redirect:/home";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userModelService.delete(id);
        return "redirect:/home";
    }
}
