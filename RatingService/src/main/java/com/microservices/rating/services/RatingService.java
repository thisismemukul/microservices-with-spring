package com.microservices.rating.services;

import com.microservices.rating.entities.Rating;

import java.util.List;

public interface RatingService {
    //create
    Rating create(Rating rating);
    //get all ratings
    List<Rating> getAllRatings();
    //get all by UserId
    List<Rating> getAllRatingsByUserId(String userId);
    //get all by HotelId
    List<Rating> getAllRatingsByHotelId(String hotelId);
}
