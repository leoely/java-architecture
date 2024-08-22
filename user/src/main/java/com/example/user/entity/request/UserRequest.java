package com.example.user.entity.request;

import java.math.BigInteger;

public record UserRequest(String id, String gender, String name, BigInteger pageNum, BigInteger pageSize) {}

