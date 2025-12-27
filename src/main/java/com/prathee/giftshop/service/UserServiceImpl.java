package com.prathee.giftshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prathee.giftshop.exception.ResourceNotFoundException;
import com.prathee.giftshop.model.User;
import com.prathee.giftshop.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public User updateUser(Long id, User user) {
        User existing = getUserById(id);
        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setRole(user.getRole());
        return userRepo.save(existing);
    }

    @Override
    public List<User> getUsersByRole(String role) {
        return userRepo.findByRole(role);
    }

    @Override
    public List<User> getUserByUsernameAndRole(String username, String role) {
        return userRepo.findByUsernameAndRole(username, role);
    }
}
