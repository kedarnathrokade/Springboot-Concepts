package com.springboot.FirstAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping(path = "/getSecretMessage")
    public  String getSecretMessage(){
        return "Secret Message : astasf!3e1345rfaws";
    }
}
