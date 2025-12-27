package com.prathee.giftshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prathee.giftshop.model.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Long> {

    List<Rating> findByProductProductId(Long productId);

    List<Rating> findByUserUserId(Long userId);

    // Average rating of a product
    @Query("SELECT AVG(r.score) FROM Rating r WHERE r.product.productId = ?1")
    Double findAverageRatingByProductId(Long productId);
}
