package com.ima.hotel.HotelService.controller;


import com.ima.hotel.HotelService.entity.Hotel;
import com.ima.hotel.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel)
    {
        Hotel save = hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getUser(@PathVariable String hotelId)
    {
        Hotel hotel = hotelService.getHotel(hotelId);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
        List<Hotel> allHotels = hotelService.getAllHotels();
        return ResponseEntity.ok(allHotels);
    }
}
