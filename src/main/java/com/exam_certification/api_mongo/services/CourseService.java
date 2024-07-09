package com.exam_certification.api_mongo.services;

import com.exam_certification.api_mongo.entities.Course;
import com.exam_certification.api_mongo.repositories.CourseRepository;
import com.exam_certification.api_mongo.controllers.request.CourseRequest;
import com.exam_certification.api_mongo.controllers.response.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    private final ModelMapper mapper;

    public CourseResponse createCourse(CourseRequest courseRequest) {
        Course course = mapper.map(courseRequest, Course.class);
        Course courseCreated = courseRepository.save(course);
        return mapper.map(courseCreated, CourseResponse.class);
    }

    public List<CourseResponse> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(el -> mapper.map(el, CourseResponse.class))
                .toList();
    }

    public Optional<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }
}
