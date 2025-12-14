package com.ima.hotel.HotelService.repositories;

import com.ima.hotel.HotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String>   {
}
