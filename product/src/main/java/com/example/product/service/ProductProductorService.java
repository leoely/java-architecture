package com.example.product.service;

import com.example.product.entity.request.ProductRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductProductorService {
  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void send(String topicName, ProductRequest productRequest) throws JsonProcessingException {
    String json = new ObjectMapper().writeValueAsString((Object) productRequest);
    kafkaTemplate.send(topicName, json);
  }
}
