package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;
import com.example.service.AccountService;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    // This repository needs to be working with the JPARepository, which directly inherits from CRUD repository
    Account findByUsername(String name); // Optional introduced in Java 8. Instead of checking if the return value is null, we can use Optional
    boolean existsByUsername(String username); // Here we are able to use the existsBy{entity field}. The @Entity and @Column annotations in the entity class help define this capability
    boolean existsByPassword(String password); // We are leveraging Spring Data JPA here again. 

    

    
}
