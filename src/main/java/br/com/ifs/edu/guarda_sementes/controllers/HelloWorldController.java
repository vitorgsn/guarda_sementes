package br.com.ifs.edu.guarda_sementes.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String HelloWorld() {
        return "Hello World!";
    };

}
