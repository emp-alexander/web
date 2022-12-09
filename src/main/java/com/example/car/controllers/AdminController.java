package com.example.car.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminController {

    @GetMapping("/redaction")
    public String redaction(Model model) {
        return "redaction";
    }

//    @GetMapping("/admin")
//    public String admin(Model model) {
//        return "admin";
//    }


}
