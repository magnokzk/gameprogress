package com.amigos.gameprogress.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @GetMapping
    public ResponseEntity<String> testMethod() {
        return ResponseEntity.ok("Funcionando");
    }

}
