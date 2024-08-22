package com.example.user.service;

import com.example.common.entity.response.UserResponse;
import com.example.user.entity.inner.UserInner;
import com.example.user.entity.request.UserRequest;
import com.example.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
  @Autowired
  UserMapper userMapper;

  public ArrayList<UserResponse> getSelectAll(UserInner userInner) {
    return userMapper.getAllSelect(userInner);
  }

  public  ArrayList<UserResponse> getSelectById(String id) {
    return userMapper.getSelectById(id);
  }
}
