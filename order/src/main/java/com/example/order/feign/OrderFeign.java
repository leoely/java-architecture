package com.example.order.feign;

import com.example.common.entity.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@FeignClient(value="USER")
public interface OrderFeign {
  @GetMapping("/users/{id}")
  public ArrayList<UserResponse> getUserById(@PathVariable String id);
}
