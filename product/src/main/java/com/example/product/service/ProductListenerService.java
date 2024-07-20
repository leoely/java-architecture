package com.example.product.service;

import com.example.product.entity.request.ProductRequest;
import com.example.product.mapper.ProductMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductListenerService {
  @Autowired
  ProductMapper productMapper;

  @KafkaListener(groupId = "groupId", topics = "insertProduct")
  public void listenerInsertProduct(String json) throws JsonProcessingException {
    ProductRequest productRequest = new ObjectMapper().readValue(json, ProductRequest.class);
    productMapper.insertProduct(productRequest);
  }
}
