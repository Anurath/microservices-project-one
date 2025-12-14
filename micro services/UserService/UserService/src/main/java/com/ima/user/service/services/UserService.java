package com.ima.user.service.services;

import com.ima.user.service.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User getUserById(String userId);

    List<User> getAllUser();

    void deleteUserById(String userId);

}
