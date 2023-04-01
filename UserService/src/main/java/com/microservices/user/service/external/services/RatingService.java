package com.microservices.user.service.external.services;

import com.microservices.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;
import java.util.Objects;
@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    //get
    //post
    @PostMapping("/ratings")
    ResponseEntity<Rating> createRating(Rating rating);
    //put
    @PutMapping("/ratings/{ratingId}")
    ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);
    //delete
    @DeleteMapping("/ratings/{ratingId}")
    ResponseEntity<Rating> deleteRating(@PathVariable String ratingId);
}
