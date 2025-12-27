package com.prathee.giftshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prathee.giftshop.model.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Long> {

    // All feedbacks for a product
    List<Feedback> findByProductProductId(Long productId);

    // All feedbacks by a user
    List<Feedback> findByUserUserId(Long userId);
}
