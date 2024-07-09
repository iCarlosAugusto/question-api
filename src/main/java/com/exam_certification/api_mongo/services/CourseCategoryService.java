package com.exam_certification.api_mongo.services;


import com.exam_certification.api_mongo.entities.CourseCategory;
import com.exam_certification.api_mongo.repositories.CourseCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseCategoryService {

    @Autowired
    final private CourseCategoryRepository courseCategoryRepository;

    public CourseCategory create() {
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setName("Cloud");
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
}
