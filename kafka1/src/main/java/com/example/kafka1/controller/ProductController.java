package com.example.kafka1.controller;

import com.example.kafka1.entity.request.ProductRequest;
import com.example.kafka1.entity.response.ProductResponse;
import com.example.kafka1.mapper.ProductMapper;
import com.example.kafka1.service.ProductProductorService;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProductController {
  @Autowired
  ProductProductorService productProductorService;

  @Autowired
  ProductMapper productMapper;

  @PostMapping("products/insert")
  public String insertProduct(@RequestBody ProductRequest productRequest) {
    productProductorService.send("insertProduct", productRequest);
    return "success";
  }

  @PostMapping("products/{id}")
  public ArrayList<ProductResponse> getProductById(@PathVariable String id) {
    return productMapper.selectProductById(id);
  }
}
