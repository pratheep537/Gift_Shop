package com.prathee.giftshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prathee.giftshop.model.Feedback;
import com.prathee.giftshop.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    // User submits feedback
    @PostMapping
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {
        return new ResponseEntity<>(
                feedbackService.createFeedback(feedback),
                HttpStatus.CREATED
        );
    }

    // View product feedback
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Feedback>> getFeedbackForProduct(
            @PathVariable Long productId) {

        return ResponseEntity.ok(
                feedbackService.getFeedbackByProduct(productId)
        );
    }
}
