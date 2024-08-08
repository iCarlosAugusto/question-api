package com.exam_certification.api_mongo.controllers.request;

import com.exam_certification.api_mongo.entities.CourseCategory;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CreateCategoryCourseRequest {
    private String name;

    public CourseCategory toEntity() {
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setName(name);
        return courseCategory;
    }
}
