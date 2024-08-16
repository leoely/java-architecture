package com.example.text.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.example.common.entity.JsonResult;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class TextService {
  @Autowired
  TextRepository textRepository;

  public ArrayList<Text> fullTextSearchText(String match) throws IOException {
    RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200, "http")).build();
    JacksonJsonpMapper jsonpMapper = new JacksonJsonpMapper();
    ElasticsearchTransport elasticsearchTransport = new RestClientTransport(restClient, jsonpMapper);
    ElasticsearchClient elasticsearchClient = new ElasticsearchClient(elasticsearchTransport);
    SearchResponse<Text> response = elasticsearchClient.search(s -> s
      .index("texts")
      .query(q -> q.match(t -> t.field("content").query(match))),
      Text.class
    );
    List<Hit<Text>> hits = response.hits().hits();
    ArrayList<Text> texts = new ArrayList<Text>();
    for (Hit<Text> hit: hits) {
      Text text = hit.source();
      texts.add(text);
    }
    elasticsearchTransport.close();
    return texts;
  }

  public void deleteTextById(String id) {
    textRepository.deleteById(id);
  }

  public void insertText(Text text) {
    textRepository.save(text);
  }
}
