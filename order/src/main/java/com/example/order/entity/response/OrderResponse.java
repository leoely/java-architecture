package com.example.order.entity.response;

import com.example.common.entity.response.UserResponse;

import java.math.BigInteger;

public record OrderResponse(BigInteger id, int count, UserResponse userResponse) {
}
