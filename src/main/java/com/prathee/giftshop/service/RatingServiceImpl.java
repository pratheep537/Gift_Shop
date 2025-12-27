package com.prathee.giftshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prathee.giftshop.exception.BadRequestException;
import com.prathee.giftshop.exception.ResourceNotFoundException;
import com.prathee.giftshop.model.Rating;
import com.prathee.giftshop.repository.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepo ratingRepo;

    public RatingServiceImpl(RatingRepo ratingRepo) {
        this.ratingRepo = ratingRepo;
    }

    @Override
    public Rating createRating(Rating rating) {
        if (rating.getScore() < 1 || rating.getScore() > 5) {
            throw new BadRequestException("Rating must be between 1 and 5");
        }
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRatingsByProduct(Long productId) {
        return ratingRepo.findByProductProductId(productId);
    }

    @Override
    public Double getAverageRating(Long productId) {
        Double avg = ratingRepo.findAverageRatingByProductId(productId);
        if (avg == null) {
            throw new ResourceNotFoundException("No ratings found for product");
        }
        return avg;
    }
}
