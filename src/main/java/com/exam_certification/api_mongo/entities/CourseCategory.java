package com.exam_certification.api_mongo.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "courseCategory")
public class CourseCategory extends BaseEntity {

    private String name;
    private String description;
    private Set<Course> courses = new HashSet<>();

}
