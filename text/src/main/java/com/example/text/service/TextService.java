package com.example.text.service;

import com.example.text.entity.inner.Text;
import com.example.text.repository.TextRepository;
import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TextService {
  @Autowired
  TextRepository textRepository;

  public String fullTextSearchText(String match) throws IOException {
    RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200, "http")).build();
    Request request = new Request("POST", "/texts/_doc/_search");
    String json = String.format("{\"query\":{\"match\":{\"content\": {\"query\":\"%s\", \"fuzziness\": \"2\"}}}}", match);
    request.setJsonEntity(json);
    Response response = restClient.performRequest(request);
    String reponseBody = EntityUtils.toString(response.getEntity());
    return reponseBody;
  }

  public void deleteTextById(String id) {
    textRepository.deleteById(id);
  }

  public void insertText(Text text) {
    textRepository.save(text);
  }
}
