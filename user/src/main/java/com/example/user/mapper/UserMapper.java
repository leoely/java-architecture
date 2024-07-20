package com.example.user.mapper;

import com.example.common.entity.response.UserResponse;
import com.example.user.entity.request.UserRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserMapper {
  ArrayList<UserResponse> getAllSelect(UserRequest request);
  ArrayList<UserResponse> getSelectById(String id);
}
