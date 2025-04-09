package com.labdessoft.roteiro1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @GetMapping("/task")
    public String listAll(){
        return "Retornar todas as tasks";
    }
}
