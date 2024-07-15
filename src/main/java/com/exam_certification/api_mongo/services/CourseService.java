package com.exam_certification.api_mongo.services;

import com.exam_certification.api_mongo.entities.Course;
import com.exam_certification.api_mongo.entities.CourseCategory;
import com.exam_certification.api_mongo.repositories.CourseRepository;
import com.exam_certification.api_mongo.controllers.request.CourseRequest;
import com.exam_certification.api_mongo.controllers.response.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final CourseCategoryService courseCategoryService;

    private final ModelMapper mapper;

    public CourseResponse createCourse(CourseRequest courseRequest) throws Exception {

        CourseCategory courseCategory = courseCategoryService.getById(
                courseRequest.getCourseCategoryId()
        ).orElseThrow(() -> new Exception("Id de categoria de curso não existe"));

        Course course = new Course();
        course.setName(courseRequest.getName());
        course.setCourseCategoryId(courseRequest.getCourseCategoryId());

        Course newCourse = courseRepository.save(course);
        courseCategoryService.addNewCourseToCategory(courseCategory, newCourse);

        return mapper.map(newCourse, CourseResponse.class);
    }

    public Page<List<Course>> getAllCourses(String categoryCourseId, Pageable pageable) {
        return courseRepository.findByCourseCategoryId(categoryCourseId, pageable);
    }

    public Optional<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }
}
