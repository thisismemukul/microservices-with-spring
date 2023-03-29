package com.microservices.hotel.controllers;

import com.microservices.hotel.entities.Hotel;
import com.microservices.hotel.services.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private HotelService hotelService;
    //create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel createdHotel = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
    }
    //get single
    //get all

}
