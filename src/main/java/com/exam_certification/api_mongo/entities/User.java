package com.exam_certification.api_mongo.entities;

import com.exam_certification.api_mongo.controllers.request.UserRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private String id;

    @Field
    private String name;

    private Set<RepliedQuestion> repliedQuestions = new HashSet<>();

    public User(UserRequest userRequest){
        this.name = userRequest.getName();
    }
}
