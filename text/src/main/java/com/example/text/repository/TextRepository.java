package com.example.text.repository;

import com.example.text.entity.inner.Text;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextRepository extends ElasticsearchRepository<Text, String> {}
