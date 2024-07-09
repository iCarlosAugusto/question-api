package com.exam_certification.api_mongo.controllers;

import com.exam_certification.api_mongo.controllers.request.UserRequest;
import com.exam_certification.api_mongo.controllers.response.QuestionResponse;
import com.exam_certification.api_mongo.entities.User;
import com.exam_certification.api_mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok().body(userService.createUser(userRequest));
    }
}
