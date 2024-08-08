package com.exam_certification.api_mongo.controllers;

import com.exam_certification.api_mongo.controllers.request.CourseRequest;
import com.exam_certification.api_mongo.controllers.request.QuestionRequest;
import com.exam_certification.api_mongo.controllers.request.ReplyQuestionRequest;
import com.exam_certification.api_mongo.controllers.response.CourseResponse;
import com.exam_certification.api_mongo.controllers.response.QuestionResponse;
import com.exam_certification.api_mongo.entities.Question;
import com.exam_certification.api_mongo.entities.RepliedQuestion;
import com.exam_certification.api_mongo.entities.User;
import com.exam_certification.api_mongo.repositories.UserRepository;
import com.exam_certification.api_mongo.services.CourseService;
import com.exam_certification.api_mongo.services.QuestionService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Field;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @PostMapping("courses/{courseId}/questions")
    ResponseEntity<QuestionResponse> createQuestion(
            @PathVariable("courseId") String courseId,
            @RequestBody QuestionRequest questionRequest
    ) throws Exception {
        return ResponseEntity.ok().body(questionService.createQuestion(questionRequest, courseId));
    }

    @GetMapping
    ResponseEntity<List<QuestionResponse>> getAllCourses() {
        return ResponseEntity.ok().body(questionService.getAllQuestions());
    }


    @GetMapping("/test")
    ResponseEntity<User> getQuestionsReplied() {
        return ResponseEntity.ok().body(questionService.getRepliedQuestions());
    }
    @PostMapping("/{questionId}/reply")
    ResponseEntity<Set<RepliedQuestion>> replyQuestion(
            @PathVariable("questionId") String questionId,
            @RequestBody ReplyQuestionRequest replyQuestionRequest
    ) throws Exception {
        return ResponseEntity.ok().body(questionService.replyQuestion(questionId, replyQuestionRequest));
    }
}
