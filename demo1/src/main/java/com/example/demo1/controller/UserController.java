package com.example.demo1.controller;

import com.example.demo1.entity.request.UserRequest;
import com.example.demo1.entity.response.UserResponse;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping("/users")
  public ArrayList<UserResponse> getUsers(@RequestBody UserRequest userRequest) {
    return userService.getSelectAll(userRequest);
  }
}
