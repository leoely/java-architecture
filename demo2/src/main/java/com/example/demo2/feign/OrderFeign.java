package com.example.demo2.feign;

import com.example.demo2.entity.request.UserRequest;
import com.example.demo2.entity.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@FeignClient(value="DEMO1")
public interface OrderFeign {
  @GetMapping("/user/{id}")
  public ArrayList<UserResponse> getUserById(@PathVariable String id);
}
