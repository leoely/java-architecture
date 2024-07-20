package com.example.user.controller;

import com.example.common.entity.JsonResult;
import com.example.common.entity.response.UserResponse;
import com.example.user.entity.request.UserRequest;
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
  public JsonResult<ArrayList<UserResponse>> getUsersAll(@RequestBody UserRequest userRequest) {
    logger.info("[Visit] Api /users/all.");
    ArrayList<UserResponse> result = userService.getSelectAll(userRequest);
    return JsonResult.ok(result);
  }

  @GetMapping("/users/{id}")
  public  JsonResult<ArrayList<UserResponse>> getUsersById(@PathVariable String id) {
    logger.info("[Visit] Api /users/{id}.");
    ArrayList<UserResponse> result = userService.getSelectById(id);
    return JsonResult.ok(result);
  }
}
