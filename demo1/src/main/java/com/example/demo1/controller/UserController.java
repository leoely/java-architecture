package com.example.demo1.controller;

import com.example.demo1.entity.User;
import com.example.demo1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {
  @Autowired
  UserMapper userMapper;

  @GetMapping("/users")
  public ArrayList<User> getUsers() {
    return userMapper.getAllSelect();
  }
}
