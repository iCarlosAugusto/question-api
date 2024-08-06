package com.exam_certification.api_mongo.controllers.request;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
