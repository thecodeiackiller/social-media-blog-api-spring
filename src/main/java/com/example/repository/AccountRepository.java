package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Account;
import com.example.service.AccountService;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    // This repository needs to be working with the JPARepository, which directly inherits from CRUD repository
    Optional<String> findByUsername(String name); // Optional introduced in Java 8. Instead of checking is the return value is null, we can use Optional
    boolean existsByUsername(String username); // 
    
}
