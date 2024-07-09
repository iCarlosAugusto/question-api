package com.exam_certification.api_mongo.controllers;

import com.exam_certification.api_mongo.controllers.request.CourseRequest;
import com.exam_certification.api_mongo.controllers.response.CourseResponse;
import com.exam_certification.api_mongo.entities.Course;
import com.exam_certification.api_mongo.entities.Question;
import com.exam_certification.api_mongo.services.CourseService;
import com.exam_certification.api_mongo.services.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    QuestionService questionService;

    @PostMapping
    ResponseEntity<CourseResponse> createCourse(@RequestBody CourseRequest courseRequest) {
        System.out.println("trigged!!!");
        return ResponseEntity.ok().body(courseService.createCourse(courseRequest));
    }

    @GetMapping
    ResponseEntity<List<CourseResponse>> getAllCourses() {
        return ResponseEntity.ok().body(courseService.getAllCourses());
    }

    @GetMapping("/{courseId}/questions")
    ResponseEntity<Page<Question>> getQuestionsByCourse(
            @PathVariable("courseId") String courseId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) throws Exception {
        return ResponseEntity.ok().body(questionService.getQuestionsByCourse(courseId));
    }
}
