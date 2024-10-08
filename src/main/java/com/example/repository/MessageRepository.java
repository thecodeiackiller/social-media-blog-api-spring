package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{
    // This repository needs to be working with the JPARepository, which directly inherits from CRUD repository
    // We have already set the annotations in the Message entity for Message @NotBlank and Message_Text @Size max 255

    public boolean existsByPostedBy(Integer postedby);

}
