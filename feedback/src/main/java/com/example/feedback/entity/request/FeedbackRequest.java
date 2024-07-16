package com.example.feedback.entity.request;

import jakarta.validation.constraints.NotBlank;

public record FeedbackRequest(
  @NotBlank(message = "Please provide an id") String id,
  @NotBlank(message = "Please provide a suggestion") String suggestion,
  @NotBlank(message = "Please provide a name") String name
) {}
