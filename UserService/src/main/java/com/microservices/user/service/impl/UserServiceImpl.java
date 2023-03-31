package com.microservices.user.service.impl;

import com.microservices.user.service.entities.Rating;
import com.microservices.user.service.entities.User;
import com.microservices.user.service.exceptions.ResourceNotFoundException;
import com.microservices.user.service.repositories.UserRepository;
import com.microservices.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        ArrayList<Rating> ratingsofUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
        logger.info("{}",ratingsofUser);
        user.setRatings(ratingsofUser);
        return user;
    }
}
