package com.exam_certification.api_mongo.controllers.request;

import com.exam_certification.api_mongo.entities.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserRequest {

    private String name;
    private String email;
    private String password;

    public User toEntity(){
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }
}
