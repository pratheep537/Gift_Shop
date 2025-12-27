package com.prathee.giftshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prathee.giftshop.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    List<User> findByRole(String role);

    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.role = ?2")
    List<User> findByUsernameAndRole(String username, String role);
}
