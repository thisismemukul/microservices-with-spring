package com.microservices.user.service;

import com.microservices.user.service.entities.Rating;
import com.microservices.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}

//	@Test
//	void createRating(){
//		Rating rating=Rating.builder().rating(10).userId("").hotelId("").feedback("This is created using feign client").build();
//	ResponseEntity<Rating> ratingResponseEntity= ratingService.createRating(rating);
//		System.out.println("New rting created");
//
//	}
}
