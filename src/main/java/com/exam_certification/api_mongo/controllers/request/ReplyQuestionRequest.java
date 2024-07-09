package com.exam_certification.api_mongo.controllers.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class ReplyQuestionRequest {

    private String userId;
    private List<String> alternativesId;
}
