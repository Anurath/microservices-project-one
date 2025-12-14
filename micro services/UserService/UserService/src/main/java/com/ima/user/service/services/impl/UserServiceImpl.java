package com.ima.user.service.services.impl;

import com.ima.user.service.entity.Hotel;
import com.ima.user.service.entity.Ratings;
import com.ima.user.service.entity.User;
import com.ima.user.service.exceptions.ResourceNotFoundException;
import com.ima.user.service.external.services.HotelService;
import com.ima.user.service.repositories.UserRepository;
import com.ima.user.service.services.UserService;
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
    UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    HotelService hotelService;


    @Override
    public User saveUser(User user) {
        String createdUserId = UUID.randomUUID().toString();
        user.setUserId(createdUserId);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with give Id is not found !!! "+ userId));
        Ratings[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/rating/user/"+user.getUserId(), Ratings[].class);
        List<Ratings> ratingList = Arrays.stream(ratingsOfUser).toList();

        List<Ratings> ratingWithHotel = ratingList.stream().map(rating -> {
//            ResponseEntity<Hotel> response = restTemplate.getForEntity("http://HOTELSERVICE/hotel/" + rating.getHotelId(), Hotel.class);
//            Hotel hotel = response.getBody();
            Hotel hotel = hotelService.getHotelById(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingWithHotel);


        return user;

    }

    @Override
    public List<User> getAllUser() {
        List<User> allUsers = userRepository.findAll();

        for(User user:allUsers)
        {
            ResponseEntity<Ratings[]> allRatings = restTemplate.getForEntity("http://RATINGSERVICE/rating/user/" + user.getUserId(), Ratings[].class);
            Ratings[] ratingList = allRatings.getBody();
            List<Ratings> listOfRating = Arrays.stream(ratingList).toList();

            List<Ratings> allRatingWithHotel = listOfRating.stream().map(rating -> {
//                ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotel/" + rating.getHotelId(), Hotel.class);
//                Hotel hotel = forEntity.getBody();
                Hotel hotel = hotelService.getHotelById(rating.getHotelId());
                rating.setHotel(hotel);
                return rating;
            }).collect(Collectors.toList());

            user.setRatings(allRatingWithHotel);
        }
        return allUsers;
    }

    @Override
    public void deleteUserById(String userId) {

    }
}
