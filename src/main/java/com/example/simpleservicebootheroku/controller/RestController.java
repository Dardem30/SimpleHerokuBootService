package com.example.simpleservicebootheroku.controller;

import com.example.simpleservicebootheroku.model.User;
import com.example.simpleservicebootheroku.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/rest/")
public class RestController {
    @Autowired
    private UserService userService;
    @GetMapping("user/{id}")
    public ResponseEntity<User> user(@PathVariable("id") int id){
        return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
    }
}
