package com.example.location.controller;

import com.example.common.entity.JsonResult;
import com.example.location.entity.request.LocationRequest;
import com.example.location.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class LocationController {
  Logger logger = LoggerFactory.getLogger(LocationController.class);

  @Autowired
  LocationService locationService;

  @PostMapping("/locations/search")
  public JsonResult<ArrayList<String>> searchLocationScope(@RequestBody LocationRequest locationRequest) {
    logger.info("[Visit] Api /locations/search.");
    ArrayList<String> result = locationService.searchScope(locationRequest);
    return JsonResult.ok(result);
  }
}
