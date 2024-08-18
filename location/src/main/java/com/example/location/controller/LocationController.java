package com.example.location.controller;

import com.example.common.entity.JsonResult;
import com.example.location.entity.request.LocationRequest;
import com.example.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class LocationController {
  @Autowired
  LocationService locationService;

  @PostMapping("/locations/search")
  public JsonResult<ArrayList<String>> searchLocationScope(@RequestBody LocationRequest locationRequest) {
    ArrayList<String> result = locationService.searchScope(locationRequest);
    return JsonResult.ok(result);
  }
}
