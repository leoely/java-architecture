package com.example.session.controller;

import com.example.common.entity.JsonResult;
import com.example.session.entity.request.SessionRequest;
import com.example.session.entity.response.SessionResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
  @PostMapping("/sessions/set")
  public JsonResult<String> setSession(@RequestBody SessionRequest sessionRequest, HttpSession session) {
    session.setAttribute("key1", sessionRequest.key1());
    session.setAttribute("key2", sessionRequest.key2());
    return JsonResult.ok("success");
  }

  @PostMapping("/sessions/get")
  public JsonResult<SessionResponse> getSession(HttpSession session) {
    int value1 = Integer.valueOf((String) session.getAttribute("key1"));
    int value2 = Integer.valueOf((String) session.getAttribute("key2"));
    SessionResponse result = new SessionResponse(value1, value2);
    return JsonResult.ok(result);
  }
}
