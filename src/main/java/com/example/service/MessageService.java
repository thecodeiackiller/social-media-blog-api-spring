package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.exception.ClientErrorException;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

@Service
public class MessageService {

    // Will use the save method to persist a message to the repository
    // We have to return a Message from the method based on the instructions containing. We can see that Id is a generatedValue in Message

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    AccountRepository accountRepository; // We are bringing this in so we can check if the postedby Id with the message has a valid id for a user
    // The intial JSON will likely contain a message_text and a posted_by, I'm assuming, so that we can verify that posted by is an actual user in the system
    public Message addMessage(Message message)
    {
        // The initial constraints are already in annotaion on entity
        // Need to check the posted_by with a existsById
        if (message.getMessageText() == "") {
            throw new ClientErrorException("Message can't be blank");
        }
        if(accountRepository.existsById(message.getPostedBy()) == true)
        {
            Message newMes = messageRepository.save(message);
            return newMes;
        }
        else
        {
            throw new ClientErrorException("Could not find associated postby id");
        }

        // We also need to, upon ensuring postedby is true, the message is persisted to db using save
    }
}
