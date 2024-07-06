package com.purohit.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
     @GetMapping("/home")
    public String register(){
        System.out.println("iiiii");
        return "home.html";
    }
}
