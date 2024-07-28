package com.example.websocket.controller;

import com.example.common.entity.JsonResult;
import com.example.websocket.entity.request.WebsocketRequest;
import com.example.websocket.entity.response.WebsocketResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {
  @MessageMapping("greeting")
  @SendTo("/client/greeting")
  public JsonResult<WebsocketResponse> greeting(WebsocketRequest websocketRequest) {
    if (websocketRequest.name().equals("server") && websocketRequest.content().equals("hello")) {
      WebsocketResponse result = new WebsocketResponse("client", "hi");
      return JsonResult.ok(result);
    }
    return JsonResult.bad("Client message format error.");
  }
}
