package com.example.car.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoreController {
    @GetMapping("/more")
    public String moreMain(Model model){
        return "more";
    }

}
