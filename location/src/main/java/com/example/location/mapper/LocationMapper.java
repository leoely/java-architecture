package com.example.location.mapper;

import com.example.location.entity.Inner.LocationInner;

import java.util.ArrayList;

public interface LocationMapper {
  ArrayList<LocationInner> selectAll();
}
