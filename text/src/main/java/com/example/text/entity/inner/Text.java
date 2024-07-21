package com.example.text.entity.inner;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "texts")
public record Text(@Id String id, String content) {}
