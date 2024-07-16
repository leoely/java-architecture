package com.example.product.mapper;

import com.example.product.entity.request.ProductRequest;
import com.example.product.entity.response.ProductResponse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductMapper {
  public void insertProduct(ProductRequest productRequest);
  public ArrayList<ProductResponse> selectProductById(String id);
}
