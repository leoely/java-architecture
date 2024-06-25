package com.example.demo1.service;

import com.example.demo1.entity.request.UserRequest;
import com.example.demo1.entity.response.UserResponse;
import com.example.demo1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
  @Autowired
  UserMapper userMapper;

  public ArrayList<UserResponse> getSelectAll(UserRequest userRequest) {
    return userMapper.getAllSelect(userRequest);
  }
}
