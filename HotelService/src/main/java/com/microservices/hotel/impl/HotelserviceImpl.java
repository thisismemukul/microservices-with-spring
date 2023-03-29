package com.microservices.hotel.impl;

import com.microservices.hotel.entities.Hotel;
import com.microservices.hotel.exceptions.ResourceNotFoundException;
import com.microservices.hotel.repositories.HotelRepository;
import com.microservices.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelserviceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel with given Id not found on server!! : "+hotelId));
    }
}
