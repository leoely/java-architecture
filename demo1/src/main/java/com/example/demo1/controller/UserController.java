package com.example.demo1.controller;

import com.example.demo1.entity.request.UserRequest;
import com.example.demo1.entity.response.UserResponse;
import com.example.demo1.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping("/users/all")
  public ArrayList<UserResponse> getUserAll(@RequestBody UserRequest userRequest) {
    return userService.getSelectAll(userRequest);
  }

  @GetMapping("/users/{id}")
  public  ArrayList<UserResponse> getUserById(@PathVariable String id) {
    return userService.getSelectById(id);
  }
}
