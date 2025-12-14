package com.ima.rating.RatingService.service;

import com.ima.rating.RatingService.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    List<Rating> getRatingByUserId(String userId);

    Rating getRatingById(String ratingId);

    List<Rating> getAllRatings();

    List<Rating> getRatingByHotelId(String hotelId);
}
