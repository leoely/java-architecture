package com.example.websocket.component;

import com.example.websocket.entity.request.WebsocketRequest;
import com.example.websocket.entity.response.WebsocketResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ServerEndpoint("/websockets")
public class WebsocketComponent {
  Logger logger = LoggerFactory.getLogger(WebsocketComponent.class);

  @OnOpen
  public void onOpen(Session session) throws JsonProcessingException {
    logger.info("[Open] Websocket /websockets.");
    WebsocketResponse websocketResponse = new WebsocketResponse("server", "hello");
    String json = new ObjectMapper().writeValueAsString(websocketResponse);
    session.getAsyncRemote().sendText(json);
  }

  @OnMessage
  public void onMessage(String json, Session session) throws JsonProcessingException {
    logger.info("[Message] Websocket /websockets.");
    WebsocketRequest websocketRequest = new ObjectMapper().readValue(json, WebsocketRequest.class);
    if (websocketRequest.name().equals("client") && websocketRequest.content().equals("hi")) {
      WebsocketResponse websocketResponse = new WebsocketResponse("server", "success");
      String json1 = new ObjectMapper().writeValueAsString(websocketResponse);
      session.getAsyncRemote().sendText(json1);
    }
  }
}
