package com.example.feedback.entity.response;

import java.math.BigInteger;

public record FeedbackResponse(BigInteger id, String suggestion, String name) {}
