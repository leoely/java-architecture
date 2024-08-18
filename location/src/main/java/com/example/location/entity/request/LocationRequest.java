package com.example.location.entity.request;

import java.math.BigDecimal;

public record LocationRequest(BigDecimal longitude, BigDecimal latitude, BigDecimal distance) {}
