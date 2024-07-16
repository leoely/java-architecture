package com.example.user.controller;

import com.example.user.entity.request.UserRequest;
import com.example.user.entity.response.UserResponse;
import com.example.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {
  @Autowired
  UserService userService;

  Logger logger = LoggerFactory.getLogger(UserController.class);

  @PostMapping("/users/all")
  public ArrayList<UserResponse> getUsersAll(@RequestBody UserRequest userRequest) {
    logger.info("[Visit] Api /users/all.");
    return userService.getSelectAll(userRequest);
  }

  @GetMapping("/users/{id}")
  public  ArrayList<UserResponse> getUsersById(@PathVariable String id) {
    logger.info("[Visit] Api /users/{id}.");
    return userService.getSelectById(id);
  }
}
