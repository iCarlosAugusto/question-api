package com.exam_certification.api_mongo.services;


import com.exam_certification.api_mongo.controllers.request.CreateCategoryCourseRequest;
import com.exam_certification.api_mongo.entities.Course;
import com.exam_certification.api_mongo.entities.CourseCategory;
import com.exam_certification.api_mongo.repositories.CourseCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CourseCategoryService {

    @Autowired
    final private CourseCategoryRepository courseCategoryRepository;

    public CourseCategory create(CreateCategoryCourseRequest createCategoryCourseRequest) {
        CourseCategory courseCategory = createCategoryCourseRequest.toEntity();
        return this.courseCategoryRepository.save(courseCategory);
    }

    public void delete(String id) {
        this.courseCategoryRepository.deleteById(id);
    }

    public List<CourseCategory> getAll(){
        return this.courseCategoryRepository.findAll();
    }

    public Optional<CourseCategory> getById(String id){
        return this.courseCategoryRepository.findById(id);
    }

    public CourseCategory addNewCourseToCategory(CourseCategory courseCategory, Course newCourse){
        Set<Course> courses = courseCategory.getCourses();
        courses.add(newCourse);
        courseCategory.setCourses(courses);
        return this.courseCategoryRepository.save(courseCategory);
    }
}
