package com.example.order.mapper;

import com.example.order.entity.inner.OrderInner;
import com.example.order.entity.request.OrderRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderMapper {
  ArrayList<OrderInner> getAllSelect(OrderRequest request);
}
