package com.example.demo2.service;

import com.example.demo2.entity.inner.OrderInner;
import com.example.demo2.entity.request.OrderRequest;
import com.example.demo2.entity.request.UserRequest;
import com.example.demo2.entity.response.OrderResponse;
import com.example.demo2.entity.response.UserResponse;
import com.example.demo2.feign.OrderFeign;
import com.example.demo2.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {
  @Autowired
  OrderMapper orderMapper;

  @Autowired
  OrderFeign orderFeign;

  public ArrayList<OrderResponse> getSelectAll(OrderRequest orderRequest) {
    ArrayList<OrderInner> orderInners = orderMapper.getAllSelect(orderRequest);
    ArrayList<OrderResponse> orderResponses = new ArrayList<OrderResponse>();
    for (OrderInner orderInner : orderInners) {
      ArrayList<UserResponse> userResponses = orderFeign.getUserById(Long.toString(orderInner.userId()));
      UserResponse userResponse = userResponses.get(0);
      OrderResponse orderResponse = new OrderResponse(orderInner.id(), orderInner.count(), userResponse);
      orderResponses.add(orderResponse);
    }
    return orderResponses;
  }
}
