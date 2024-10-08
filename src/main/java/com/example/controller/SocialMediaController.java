package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.service.AccountService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

 @RestController // Forgot this at the beginning
public class SocialMediaController {
    // We'll need to use Responsebody and PathVariable to get and send information within our APIs URI

    // The goal of the this is the register a user and return a response body in the form of JSON
    // For this, we will have to utilize the ResponseBody annotations. We won't need ParameterRequest just yet
    // We need to inject Account Service

    @Autowired 
    AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<Account> registerUser(@RequestBody Account account) // We forgot to add the @ResponseBody annotation in the method signature
    {
        
        // In order to use an account instance, we need to set up Dependency Injection for it. Do we need to setup a Bean for this?
        // So Spring automatically created a bean for services that are annotated with @Service, so all we have to do is AutoWire

         Account newAccount = accountService.registerUser(account);
         // If we need to return a @ResponseBody, then we need use HttpRequest along with a generic status
         return ResponseEntity.ok(newAccount);

    }
}
