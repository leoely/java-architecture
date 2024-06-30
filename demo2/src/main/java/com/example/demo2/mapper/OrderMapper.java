package com.example.demo2.mapper;

import com.example.demo2.entity.inner.OrderInner;
import com.example.demo2.entity.request.OrderRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderMapper {
  ArrayList<OrderInner> getAllSelect(OrderRequest request);
}
