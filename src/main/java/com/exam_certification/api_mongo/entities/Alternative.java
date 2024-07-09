package com.exam_certification.api_mongo.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Alternative {
    @Id
    private String id;
    private boolean correct;
    private String text;
}
