package com.example.guru_api.repository;

import com.example.guru_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // mencari user berdasarkan username untuk login
    Optional<User> findByUsername(String username);

}