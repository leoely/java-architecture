package com.example.common.enumerate;

import com.fasterxml.jackson.annotation.JsonValue;

public enum HttpStatus {
  OK(200), BAD(500);

  private final int value;

  private HttpStatus(int code) {
    this.value = code;
  }

  public int getValue() {
    return value;
  }

  @JsonValue
  public String toString() {
    return String.valueOf(this.value);
  }
}
