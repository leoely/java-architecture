package com.example.demo1.mapper;

import com.example.demo1.entity.request.UserRequest;
import com.example.demo1.entity.response.UserResponse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserMapper {
  ArrayList<UserResponse> getSelectAll(UserRequest request);
  ArrayList<UserResponse> getSelectById(String id);
}
