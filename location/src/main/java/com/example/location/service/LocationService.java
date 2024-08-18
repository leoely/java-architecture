package com.example.location.service;

import com.example.location.entity.Inner.LocationInner;
import com.example.location.entity.request.LocationRequest;
import com.example.location.mapper.LocationMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.domain.geo.GeoLocation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;

@Service
public class LocationService {
  @Autowired
  LocationMapper locationMapper;

  @Autowired
  StringRedisTemplate stringRedisTemplate;

  final static String KEY = "locations";

  @PostConstruct
  void prepareLocations() {
    ArrayList<LocationInner> locations = locationMapper.selectAll();
    for (LocationInner location : locations) {
      Point point = new Point(location.longitude().doubleValue(), location.latitude().doubleValue());
      stringRedisTemplate.opsForGeo().add(KEY, point, location.name());
    }
  }

  public ArrayList<String> searchScope(LocationRequest locationRequest) {
    Circle circle = new Circle(new Point(locationRequest.longitude().doubleValue(), locationRequest.latitude().doubleValue()), locationRequest.distance().doubleValue());
    RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().sortAscending().limit(10);
    GeoResults<RedisGeoCommands.GeoLocation<String>> geoResults = stringRedisTemplate.opsForGeo().radius(KEY, circle, args);
    return geoResults.getContent().stream().map(GeoResult::getContent).map(GeoLocation::getName).collect(toCollection(ArrayList::new));
  }
}
