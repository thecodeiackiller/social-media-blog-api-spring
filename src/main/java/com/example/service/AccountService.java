package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;


    //  The response status should be 200 OK, which is the default. The new account should be persisted to the database.
    //  If the registration is not successful due to a duplicate username, the response status should be 409. (Conflict)
    //  If the registration is not successful for some other reason, the response status should be 400. (Client error)

    // 3. The registration will be successful if and only if the username is not blank
    // 4. The registration will be successful if the password is at least 4 characters long
    // 5. The registration will be successful if the Account with that username does not already exist. 

    // This is going to contain a response body of a JSON account, so I'm unsure whether or not we handle this with ResponseBody in Controller or what
    // We need to return an account which will be apart of the ResponseBody in the controller


    // public Account registerUser(Account account)
    // {
        //  I began handcrafting a registerUser method with all the condition but thought It would be easier if we just used lombok or jakarta as this is what we have Spring for
    // }


}
