package com.microservices.user.service.impl;

import com.microservices.user.service.entities.Hotel;
import com.microservices.user.service.entities.Rating;
import com.microservices.user.service.entities.User;
import com.microservices.user.service.exceptions.ResourceNotFoundException;
import com.microservices.user.service.repositories.UserRepository;
import com.microservices.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserService.class);
    @Override
    public User saveUser(User user) {
        //generate unique userId
        String randomUserID = UUID.randomUUID().toString();
        user.setUserId(randomUserID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        //TODO: implement rating call using REST TEMPLATE
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        //get user from db with the help of user repo
        User user= userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given Id not found on server!! : "+userId));
        //fetch rating of the above user from RATING SERVICE
        //http://localhost:8083/ratings/users/daa20c20-b91f-43f4-81b7-93b198c0c74f
        Rating[] ratingsofUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);

       List<Rating> ratings= Arrays.stream(ratingsofUser).toList();
        List<Rating> ratingList=  ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
          ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
          Hotel hotel = forEntity.getBody();
          logger.info("response status code {}",forEntity.getStatusCode());
          //set the hotel to rating
          rating.setHotel(hotel);
            //return the rating
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }
}
