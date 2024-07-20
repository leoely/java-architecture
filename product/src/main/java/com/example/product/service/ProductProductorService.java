package com.example.product.service;

import com.example.product.entity.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductProductorService {
  @Autowired
  private KafkaTemplate<String, ProductRequest> kafkaTemplate;

  public void send(String topicName, ProductRequest productRequest) {
    kafkaTemplate.send(topicName, productRequest);
  }
}