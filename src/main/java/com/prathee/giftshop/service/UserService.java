package com.prathee.giftshop.service;

import java.util.List;

import com.prathee.giftshop.model.User;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, User user);

    List<User> getUsersByRole(String role);

    List<User> getUserByUsernameAndRole(String username, String role);
}
