package com.exam_certification.api_mongo.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "courseCategory")
public class CourseCategory extends BaseEntity {

    private String name;

    private String description;

}
