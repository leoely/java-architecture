package com.example.product.entity.response;

import java.math.BigInteger;

public record ProductResponse(BigInteger id, String name, Integer status, Integer dirty) {}
