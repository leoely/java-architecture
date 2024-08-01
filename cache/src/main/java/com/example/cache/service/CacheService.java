package com.example.cache.service;

import com.example.cache.entity.response.CacheResponse;
import com.example.cache.mapper.CacheMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
  final String CACHE_KEY = "caches";

  @Autowired
  StringRedisTemplate stringRedisTemplate;

  @Autowired
  CacheMapper cacheMapper;

  @PostConstruct
  void perpareKey() {
    if (!stringRedisTemplate.hasKey(this.CACHE_KEY)) {
      stringRedisTemplate.opsForList().leftPush(this.CACHE_KEY, "");
    }
  }

  public CacheResponse selectCacheById(String id) throws JsonProcessingException {
    String cache = stringRedisTemplate.opsForList().index(this.CACHE_KEY, Long.valueOf(id));
    CacheResponse result;
    if (cache == null || cache.equals("")) {
      CacheResponse cacheResponse = cacheMapper.selectCacheById(id);
      String json = new ObjectMapper().writeValueAsString(cacheResponse);
      stringRedisTemplate.opsForList().set(this.CACHE_KEY, Long.valueOf(id), json);
      result = cacheResponse;
    } else {
      result = new ObjectMapper().readValue(cache, CacheResponse.class);
    }
    return result;
  }
}
