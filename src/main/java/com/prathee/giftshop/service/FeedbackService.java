package com.prathee.giftshop.service;

import java.util.List;

import com.prathee.giftshop.model.Feedback;

public interface FeedbackService {

    Feedback createFeedback(Feedback feedback);

    List<Feedback> getFeedbackByProduct(Long productId);

    List<Feedback> getFeedbackByUser(Long userId);
}
