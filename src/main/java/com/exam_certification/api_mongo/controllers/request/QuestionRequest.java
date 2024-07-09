package com.exam_certification.api_mongo.controllers.request;

import com.exam_certification.api_mongo.entities.Alternative;
import com.exam_certification.api_mongo.entities.enums.QuestionType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
public class QuestionRequest {
    private String text;
    private QuestionType questionType;
    private String courseId;
    private List<Alternative> alternatives;
}
