package com.prathee.giftshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prathee.giftshop.exception.BadRequestException;
import com.prathee.giftshop.model.Feedback;
import com.prathee.giftshop.repository.FeedbackRepo;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepo feedbackRepo;

    public FeedbackServiceImpl(FeedbackRepo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }

    @Override
    public Feedback createFeedback(Feedback feedback) {
        if (feedback.getRating() < 1 || feedback.getRating() > 5) {
            throw new BadRequestException("Feedback rating must be between 1 and 5");
        }
        return feedbackRepo.save(feedback);
    }

    @Override
    public List<Feedback> getFeedbackByProduct(Long productId) {
        return feedbackRepo.findByProductProductId(productId);
    }

    @Override
    public List<Feedback> getFeedbackByUser(Long userId) {
        return feedbackRepo.findByUserUserId(userId);
    }
}
