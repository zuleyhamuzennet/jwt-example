package com.ba.jwt.controller;

import com.ba.jwt.dto.Users;
import com.ba.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok("Merhaba JWT");
    }

  /*  @GetMapping("/list")
    public List<Users> listAllUser(){
        List<Users> users= userRepository.findAll();
        return users;
    }*/
}
