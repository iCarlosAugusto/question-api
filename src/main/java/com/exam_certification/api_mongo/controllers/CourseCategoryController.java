package com.exam_certification.api_mongo.controllers;

import com.exam_certification.api_mongo.entities.CourseCategory;
import com.exam_certification.api_mongo.services.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courseCategory")
public class CourseCategoryController {

    @Autowired
    private  CourseCategoryService courseCategoryService;


    @DeleteMapping("/{id}")
    void deleteCategoryCourse(@PathVariable("id") String categoryCourseId) {
        this.courseCategoryService.delete(categoryCourseId);
    }

    @GetMapping()
    ResponseEntity<List<CourseCategory>> getAllCoursesCategories() {
        return ResponseEntity.ok().body(this.courseCategoryService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<CourseCategory>> getAllCoursesCategories(@PathVariable("id") String categoryCourseId) {
        return  ResponseEntity.ok().body(this.courseCategoryService.getById(categoryCourseId));
    }

    @PostMapping
    ResponseEntity<CourseCategory> createCategoryCourse() {
        return ResponseEntity.ok().body(this.courseCategoryService.create());
    }
}
