package com.example.kafka1.mapper;

import com.example.kafka1.entity.request.ProductRequest;
import com.example.kafka1.entity.response.ProductResponse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductMapper {
  public void insertProduct(ProductRequest productRequest);
  public ArrayList<ProductResponse> selectProductById(String id);
}
