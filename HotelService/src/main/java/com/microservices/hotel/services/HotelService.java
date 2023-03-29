package com.microservices.hotel.services;

import com.microservices.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {
    //create
    Hotel create(Hotel hotel);
    //getAll
    List<Hotel>getAll();
    //get single
    Hotel get(String id);

    //TODO: delete
}
