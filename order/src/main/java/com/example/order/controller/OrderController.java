package com.example.order.controller;

import com.example.order.entity.request.OrderRequest;
import com.example.order.entity.response.OrderResponse;
import com.example.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class OrderController {
  @Autowired
  OrderService orderService;

  Logger logger = LoggerFactory.getLogger(OrderController.class);

  @PostMapping("/orders/all")
  public ArrayList<OrderResponse> getOrdersAll(@RequestBody OrderRequest orderRequest) {
    logger.info("[Visit] Api /orders/all.");
    return orderService.getSelectAll(orderRequest);
  }
}
