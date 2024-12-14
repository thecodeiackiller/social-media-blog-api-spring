# Project: Spring Social Media Blog API

## Background
This project serves as the backend for a hypothetical social media app, managing user accounts and messages. It leverages the Spring framework for automatic injection and configuration of features such as data persistence, endpoints, and CRUD operations. Users can view all messages or those from specific users, while the API handles logins, registrations, message creations, updates, and deletions.

## Database Tables
The following tables are initialized in your project's built-in database upon startup using the configuration details in the `application.properties` file and the provided SQL script.

- **Account**
  - `accountId` integer primary key auto_increment,
  - `username` varchar(255) not null unique,
  - `password` varchar(255)

- **Message**
  - `messageId` integer primary key auto_increment,
  - `postedBy` integer,
  - `messageText` varchar(255),
  - `timePostedEpoch` long,
  - foreign key (postedBy) references Account(accountId)

## Spring Technical Requirement
The project utilizes the Spring Boot Framework. It includes a bean for the `AccountService`, `MessageService`, `AccountRepository`, `MessageRepository`, and `SocialMediaController` classes. The app employs Spring MVC and Spring Data, ensuring a robust architecture.

## User Stories
1. **User Registration**: Users can create an account at `POST localhost:8080/register`. Successful registration requires a unique username and a password of at least 4 characters. If successful, the response includes the account details with a status of 200 OK. Otherwise, the status is 400 (client error) or 409 (conflict).

2. **User Login**: Users can log in at `POST localhost:8080/login`. A successful login returns the account details and a status of 200 OK. If unsuccessful, the status is 401 (unauthorized).

3. **Create Message**: Users can post a message at `POST localhost:8080/messages`. The message must not exceed 255 characters and must be linked to a valid user. Successful creation returns the message details and a status of 200. If unsuccessful, the status is 400 (client error).

4. **Retrieve All Messages**: Users can retrieve all messages with a `GET` request to `GET localhost:8080/messages`, returning a JSON list of messages or an empty list with a status of 200.

5. **Retrieve Message by ID**: Users can retrieve a specific message with a `GET` request to `GET localhost:8080/messages/{messageId}`, receiving the message details or an empty response with a status of 200.

6. **Delete Message**: Users can delete a message with a `DELETE` request to `DELETE localhost:8080/messages/{messageId}`. The response indicates the number of rows updated (1 for a successful deletion) and a status of 200.

7. **Update Message**: Users can update a message using a `PATCH` request to `PATCH localhost:8080/messages/{messageId}`. A successful update returns the number of rows updated (1) and a status of 200. If unsuccessful, the status is 400 (client error).

8. **Retrieve User Messages**: Users can retrieve messages by a specific user with a `GET` request to `GET localhost:8080/accounts/{accountId}/messages`, receiving a list of messages or an empty response with a status of 200.

9. **Spring Framework Utilization**: The project utilizes the Spring framework, including dependency injection and Spring annotations, enhancing code organization and functionality.

## Description
This repository contains the Spring Social Media Blog API, developed during an 11-week Java training course. It demonstrates backend concepts, utilizing Spring and its dependencies, including RESTful API design and data persistence. The project features user registration, login, and message handling, structured within a 3-layer architecture for scalability and maintainability.

