package com.example.point.controller;

import com.example.common.entity.JsonResult;
import com.example.point.entity.request.PointRequest;
import com.example.point.entity.response.PointResponse;
import com.example.point.service.PointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PointController {
  Logger logger = LoggerFactory.getLogger(PointController.class);

  @Autowired
  PointService pointService;

  @PostMapping("/points/all")
  JsonResult<ArrayList<PointResponse>> getAllSelect(@RequestBody PointRequest pointRequest) {
    logger.info("[Visit] Api /orders/all.");
    ArrayList<PointResponse> result = pointService.getAllSelect(pointRequest);
    return JsonResult.ok(result);
  }
}
