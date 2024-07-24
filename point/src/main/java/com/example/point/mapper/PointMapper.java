package com.example.point.mapper;

import com.example.point.entity.inner.PointInner;
import com.example.point.entity.request.PointRequest;
import com.example.point.entity.response.PointResponse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PointMapper {
  ArrayList<PointResponse> getAllSelect(PointRequest pointRequest);
  void update(PointInner pointInner);
}
