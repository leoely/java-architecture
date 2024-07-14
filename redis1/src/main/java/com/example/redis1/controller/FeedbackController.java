package com.example.redis1.controller;

import com.example.redis1.entity.inner.Feedback;
import com.example.redis1.entity.request.StudentRequest;
import com.example.redis1.entity.response.FeedbackResponse;
import com.example.redis1.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedbackController {
  @Autowired
  private FeedbackRepository feedbackRepository;

  @PostMapping("/feedbacks/insert")
  void insertFeedback(@RequestBody StudentRequest studentRequest) {
    Feedback feedback = new Feedback(studentRequest.id(), studentRequest.suggestion(), studentRequest.name());
    feedbackRepository.save(feedback);
  }

  @PostMapping("/feedbacks/{id}")
  FeedbackResponse getFeedbackById(@PathVariable String id) {
    Feedback feedback = (Feedback) feedbackRepository.findById(id).get();
    FeedbackResponse feedbackResponse = new FeedbackResponse(Integer.valueOf(feedback.id()), feedback.suggestion(), feedback.name());
    return feedbackResponse;
  }
}
