package com.ima.user.service.external.services;

import com.ima.user.service.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTELSERVICE")
public interface HotelService {
    @GetMapping("/hotel/{hotelId}")
    Hotel getHotelById(@PathVariable String hotelId);
}
