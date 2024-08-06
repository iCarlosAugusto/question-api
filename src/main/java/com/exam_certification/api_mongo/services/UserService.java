package com.exam_certification.api_mongo.services;

import com.exam_certification.api_mongo.controllers.request.AuthRequest;
import com.exam_certification.api_mongo.controllers.request.UserRequest;
import com.exam_certification.api_mongo.entities.User;
import com.exam_certification.api_mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(UserRequest userRequest){
       User user = userRequest.toEntity();
       return userRepository.save(user);
    }

    public Optional<User> auth(AuthRequest authRequest){
        return userRepository.findByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword());
    }
}
