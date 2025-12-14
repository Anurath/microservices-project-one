package com.ima.hotel.HotelService.service.impl;

import com.ima.hotel.HotelService.entity.Hotel;
import com.ima.hotel.HotelService.exception.ResourceNotFoundException;
import com.ima.hotel.HotelService.repositories.HotelRepository;
import com.ima.hotel.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel getHotel(String hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id: " + hotelId + " is not present."));
        return hotel;
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String createdHotelId = UUID.randomUUID().toString();
        hotel.setId(createdHotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
