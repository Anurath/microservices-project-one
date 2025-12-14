package com.ima.user.service.external.services;

import com.ima.user.service.entity.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="RATINGSERVICE")
public interface RatingService {
    @GetMapping("/user/{userId}")
    ResponseEntity<List<Ratings>> getRatingsById(@PathVariable String userId);
}
