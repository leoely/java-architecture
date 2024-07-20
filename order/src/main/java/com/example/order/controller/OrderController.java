package com.example.order.controller;

import com.example.common.entity.JsonResult;
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
  public JsonResult<ArrayList<OrderResponse>> getOrdersAll(@RequestBody OrderRequest orderRequest) {
    logger.info("[Visit] Api /orders/all.");
    ArrayList<OrderResponse> result = orderService.getSelectAll(orderRequest);
    return JsonResult.ok(result);
  }
}
