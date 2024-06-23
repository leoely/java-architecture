package com.example.demo1.mapper;

import com.example.demo1.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserMapper {
  ArrayList<User> getAllSelect();
}
