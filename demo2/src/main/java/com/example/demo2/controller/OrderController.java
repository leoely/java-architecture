package com.example.demo2.controller;

import com.example.demo2.entity.inner.OrderInner;
import com.example.demo2.entity.request.OrderRequest;
import com.example.demo2.entity.response.OrderResponse;
import com.example.demo2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class OrderController {
  @Autowired
  OrderService orderService;

  @PostMapping("/order/all")
  public ArrayList<OrderResponse> getOrderAll(@RequestBody OrderRequest orderRequest) {
    return orderService.getSelectAll(orderRequest);
  }
}
