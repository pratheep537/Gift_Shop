package com.prathee.giftshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prathee.giftshop.model.Rating;
import com.prathee.giftshop.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // User rates product
    @PostMapping
    public ResponseEntity<Rating> rateProduct(@RequestBody Rating rating) {
        return new ResponseEntity<>(
                ratingService.createRating(rating),
                HttpStatus.CREATED
        );
    }

    // Analytics
    @GetMapping("/product/{productId}/average")
    public ResponseEntity<Double> getAverageRating(
            @PathVariable Long productId) {

        return ResponseEntity.ok(
                ratingService.getAverageRating(productId)
        );
    }
}
