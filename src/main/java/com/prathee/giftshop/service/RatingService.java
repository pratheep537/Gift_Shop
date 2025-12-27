package com.prathee.giftshop.service;

import java.util.List;

import com.prathee.giftshop.model.Rating;

public interface RatingService {

    Rating createRating(Rating rating);

    List<Rating> getRatingsByProduct(Long productId);

    Double getAverageRating(Long productId);
}
