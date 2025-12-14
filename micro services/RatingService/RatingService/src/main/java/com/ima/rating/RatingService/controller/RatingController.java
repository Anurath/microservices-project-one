package com.ima.rating.RatingService.controller;

import com.ima.rating.RatingService.entity.Rating;
import com.ima.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {
        Rating save = ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable String ratingId)
    {
        Rating rating = ratingService.getRatingById(ratingId);
        return ResponseEntity.ok(rating);
    }

    @GetMapping
    private ResponseEntity<List<Rating>> getAllRatings()
    {
        List<Rating> allRatings = ratingService.getAllRatings();
        return ResponseEntity.ok(allRatings);
    }

    @GetMapping("/user/{userId}")
    private ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId)
    {
        List<Rating> allRatings = ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(allRatings);
    }

    @GetMapping("/hotel/{hotelId}")
    private ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
    {
        List<Rating> allRatings = ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.ok(allRatings);
    }


}
