package com.example.order.entity.response;

import com.example.common.entity.response.UserResponse;

public record OrderResponse(long id, int count, UserResponse userResponse) {
}
