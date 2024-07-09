package com.exam_certification.api_mongo.entities;


import com.exam_certification.api_mongo.controllers.request.QuestionRequest;
import com.exam_certification.api_mongo.entities.enums.QuestionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Document(collection = "questions")
@Getter
@Setter
@NoArgsConstructor
public class Question {

    @Id
    private String id;
    private String text;
    private QuestionType questionType;
    private List<Alternative> alternatives;
    private Course course;


    public Question(QuestionRequest questionRequest){
        this.text = questionRequest.getText();
        this.questionType = questionRequest.getQuestionType();

        this.alternatives = new ArrayList<>();
        for (Alternative alternative : questionRequest.getAlternatives()) {
            String alternativeId = UUID.randomUUID().toString();

            Alternative newAlternative = new Alternative();
            newAlternative.setId(alternativeId);
            newAlternative.setText(alternative.getText());
            newAlternative.setCorrect(alternative.isCorrect());

            this.alternatives.add(newAlternative);
        }
    }
}
