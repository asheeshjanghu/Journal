package com.memory.Journal.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

    @GetMapping("/home")
    public String getHomePage() {
        return "Welcome to Journal App";
    }
}
