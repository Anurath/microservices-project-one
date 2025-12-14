package com.ima.hotel.HotelService.service;

import com.ima.hotel.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel getHotel(String hotelId);

    Hotel saveHotel(Hotel hotel);

    List<Hotel> getAllHotels();


}
