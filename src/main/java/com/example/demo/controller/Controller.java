package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    @GetMapping("/")
    public ResponseEntity<?> getGreeting() {
        return ResponseEntity.ok("Приветствую =)");
    }
}
