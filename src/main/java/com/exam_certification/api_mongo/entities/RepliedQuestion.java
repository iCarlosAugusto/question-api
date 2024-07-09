package com.exam_certification.api_mongo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RepliedQuestion {

    private boolean isCorrect;
    private Question question;
}
