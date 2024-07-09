package com.exam_certification.api_mongo.repositories;

import com.exam_certification.api_mongo.entities.CourseCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseCategoryRepository extends MongoRepository<CourseCategory, String> {
}
