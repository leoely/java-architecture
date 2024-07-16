package com.example.product.controller;

import com.example.product.entity.request.ProductRequest;
import com.example.product.entity.response.ProductResponse;
import com.example.product.mapper.ProductMapper;
import com.example.product.service.ProductProductorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  Logger logger = LoggerFactory.getLogger(ProductController.class);

  @PostMapping("products/insert")
  public String insertProducts(@RequestBody ProductRequest productRequest) {
    logger.info("[Visit] Api /products/insert.");
    productProductorService.send("insertProduct", productRequest);
    return "success";
  }

  @PostMapping("products/{id}")
  public ArrayList<ProductResponse> getProductsById(@PathVariable String id) {
    logger.info("[Visit] Api /products/insert.");
    return productMapper.selectProductById(id);
  }
}
