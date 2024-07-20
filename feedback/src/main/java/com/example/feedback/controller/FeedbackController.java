package com.example.feedback.controller;

import com.example.common.entity.JsonResult;
import com.example.feedback.entity.inner.Feedback;
import com.example.feedback.entity.request.FeedbackRequest;
import com.example.feedback.entity.response.FeedbackResponse;
import com.example.feedback.repository.FeedbackRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedbackController {
  @Autowired
  private FeedbackRepository feedbackRepository;

  Logger logger = LoggerFactory.getLogger(FeedbackController.class);

  @PostMapping("/feedbacks/insert")
  void insertFeedback(@RequestBody @Valid FeedbackRequest studentRequest) {
    logger.info("[Visit] Api /feedbacks/insert.");
    Feedback feedback = new Feedback(studentRequest.id(), studentRequest.suggestion(), studentRequest.name());
    feedbackRepository.save(feedback);
  }

  @PostMapping("/feedbacks/{id}")
  JsonResult<FeedbackResponse> getFeedbackById(@PathVariable String id) {
    logger.info("[Visit] Api /feedbacks/{id}.");
    Feedback feedback = (Feedback) feedbackRepository.findById(id).get();
    FeedbackResponse result = new FeedbackResponse(Integer.valueOf(feedback.id()), feedback.suggestion(), feedback.name());
    return JsonResult.ok(result);
  }
}
