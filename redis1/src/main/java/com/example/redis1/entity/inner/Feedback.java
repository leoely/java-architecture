package com.example.redis1.entity.inner;

import org.springframework.data.redis.core.RedisHash;

@RedisHash(timeToLive = 60 * 60 * 24)
public record Feedback(String id, String suggestion, String name) { }
