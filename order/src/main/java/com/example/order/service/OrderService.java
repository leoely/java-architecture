package com.example.order.service;

import com.example.order.entity.inner.OrderInner;
import com.example.order.entity.request.OrderRequest;
import com.example.order.entity.response.OrderResponse;
import com.example.common.entity.response.UserResponse;
import com.example.order.feign.OrderFeign;
import com.example.order.mapper.OrderMapper;
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
