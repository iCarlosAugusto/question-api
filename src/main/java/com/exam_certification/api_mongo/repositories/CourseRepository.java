package com.exam_certification.api_mongo.repositories;

import com.exam_certification.api_mongo.entities.Course;
import com.exam_certification.api_mongo.entities.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {

    Page<List<Course>> findByCourseCategoryId(String courseCategoryId, Pageable page);
}
