package com.example.springboot2.repository;

import com.example.springboot2.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserName(String username);
}
