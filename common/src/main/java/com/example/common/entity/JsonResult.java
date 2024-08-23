package com.example.common.entity;

import com.example.common.enumerate.HttpStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class JsonResult<T> {
  private final HttpStatus status;
  private final T data;
  private final String message;

  @JsonCreator
  public JsonResult(HttpStatus status, String message, T data) {
    this.status = status;
    this.data = data;
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

  public static <T> JsonResult<T> ok(T data) {
    return new JsonResult<T>(HttpStatus.OK, null, data);
  }

  public static <E> JsonResult<E> bad(String message) {
    return new JsonResult<E>(HttpStatus.BAD, message, null);
  }
}
