package com.example.point.service;

import com.example.point.entity.request.PointRequest;
import com.example.point.entity.response.PointResponse;
import com.example.point.mapper.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PointService {
  @Autowired
  PointMapper pointMapper;

  public ArrayList<PointResponse> getAllSelect(PointRequest pointRequest) {
    return pointMapper.getAllSelect(pointRequest);
  }
}
