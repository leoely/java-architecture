package com.example.cache.mapper;

import com.example.cache.entity.response.CacheResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheMapper {
  CacheResponse selectCacheById(String id);
}
