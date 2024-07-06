package com.example.kafka1.service;

import com.example.kafka1.entity.request.ProductRequest;
import com.example.kafka1.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductListenerService {
  @Autowired
  ProductMapper productMapper;

  @KafkaListener(groupId = "groupId", topics = "insertProduct")
  public void listenerInsertProduct(ProductRequest productRequest) {
    productMapper.insertProduct(productRequest);
  }
}
