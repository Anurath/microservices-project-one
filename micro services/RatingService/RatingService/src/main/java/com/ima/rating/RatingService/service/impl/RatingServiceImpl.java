package com.ima.rating.RatingService.service.impl;

import com.ima.rating.RatingService.entity.Rating;
import com.ima.rating.RatingService.exception.ResourceNotFoundException;
import com.ima.rating.RatingService.repository.RatingRepository;
import com.ima.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {


    @Autowired
    private RatingRepository ratingRepository;


    @Override
    public Rating getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFoundException("Rating with given Id is not present."));
    }

    @Override
    public Rating createRating(Rating rating) {
        String createdRatingId = UUID.randomUUID().toString();
        rating.setId(createdRatingId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.getRatingByUserId(userId);
    }


    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.getRatingByHotelId(hotelId);
    }
}
