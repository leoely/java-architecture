package com.example.feedback.repository;

import com.example.feedback.entity.inner.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, String> {}
