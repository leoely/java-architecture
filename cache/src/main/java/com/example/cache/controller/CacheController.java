package com.example.cache.controller;

import com.example.cache.service.CacheService;
import com.example.common.entity.JsonResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cache.entity.response.CacheResponse;

@RestController
public class CacheController {
  Logger logger = LoggerFactory.getLogger(CacheController.class);

  @Autowired
  CacheService cacheService;

  @GetMapping("/caches/{id}")
  public JsonResult<CacheResponse> getCacheById(@PathVariable String id) throws JsonProcessingException {
    logger.info("[Visit] Api /caches/{id}.");
    CacheResponse result = cacheService.selectCacheById(id);
    return JsonResult.ok(result);
  }
}
