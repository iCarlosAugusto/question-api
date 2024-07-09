package com.exam_certification.api_mongo.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    private String id;
    private String name;
}
