package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{
    // This repository needs to be working with the JPARepository, which directly inherits from CRUD repository
    // We have already set the annotations in the Message entity for Message @NotBlank and Message_Text @Size max 255

    public boolean existsByPostedBy(Integer postedby);

    public List<Message> findAll();
    public Message findBymessageId(Integer messageId);
    
    public boolean existsBymessageId(Integer messageId);
    public void deleteBymessageId(Integer messageId);

    public List<Message> findByPostedBy(Integer accountId);

}
