package com.example.point.schedule;

import com.example.point.entity.inner.PointInner;
import com.example.point.entity.request.PointRequest;
import com.example.point.entity.response.PointResponse;
import com.example.point.mapper.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;

@Component
public class ScheduleTask {
  @Autowired
  PointMapper pointMapper;

  @Scheduled(fixedRate = 1000 * 60 * 60 * 24)
  public void addPoint() {
    PointRequest pointRequest = new PointRequest(null, null);
    ArrayList<PointResponse> pointResponses = pointMapper.getAllSelect(pointRequest);
    ArrayList<PointInner> pointInners = new ArrayList<PointInner>();
    for (PointResponse pointResponse: pointResponses) {
      PointInner pointInner = new PointInner(pointResponse.id(), pointResponse.count().add(BigInteger.valueOf(1)));
      pointMapper.update(pointInner);
    }
  }
}
