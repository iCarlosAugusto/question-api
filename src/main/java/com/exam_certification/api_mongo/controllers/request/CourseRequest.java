package com.exam_certification.api_mongo.controllers.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CourseRequest {
    private String name;
    private String courseCategoryId;
}
