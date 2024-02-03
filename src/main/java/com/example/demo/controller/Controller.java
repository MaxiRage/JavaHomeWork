package com.example.demo.controller;

import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class Controller {

    @PostMapping("/registration")
    public ResponseEntity<?> getRegistration(@RequestBody User.Request.UserDTO userDTO) {
        return new ResponseEntity<>(User.Response.RegistrationDTO.builder()
                .timeRegistration(LocalDateTime.now())
                .name(userDTO.getName())
                .role("user")
                .build(), OK);
    }
}
