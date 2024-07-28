package com.example.common.entity;

import com.example.common.enumerate.HttpStatus;

public class JsonResult<T> {
  private final HttpStatus status;
  private final T data;
  private final String message;

  public JsonResult(HttpStatus httpStatus, String message, T data) {
    this.status = httpStatus;
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
