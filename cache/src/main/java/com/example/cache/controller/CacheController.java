package com.example.cache.controller;

import com.example.cache.service.CacheService;
import com.example.common.entity.JsonResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cache.entity.response.CacheResponse;

@RestController
public class CacheController {
  @Autowired
  CacheService cacheService;

  @GetMapping("/caches/{id}")
  public JsonResult<CacheResponse> getCacheById(@PathVariable String id) throws JsonProcessingException {
    CacheResponse result = cacheService.selectCacheById(id);
    return JsonResult.ok(result);
  }
}
