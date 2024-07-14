package com.example.redis1.repository;

import com.example.redis1.entity.inner.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, String> {}
