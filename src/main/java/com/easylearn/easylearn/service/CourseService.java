package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Course;
import com.easylearn.easylearn.model.CourseReqDTO;
import com.easylearn.easylearn.model.CourseRespDTO;
import com.easylearn.easylearn.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ResponseEntity<CourseRespDTO> createCourse(CourseReqDTO request) {
        Course course = Course.builder()
                .courseCode(request.getCourseCode())
                .name(request.getName())
                .content(request.getContent())
                .grade(request.getGrade())
                .description(request.getDescription())
                .build();

        course = courseRepository.save(course);

        CourseRespDTO response = CourseRespDTO.builder()
                .courseCode(course.getCourseCode())
                .name(course.getName())
                .content(course.getContent())
                .grade(course.getGrade())
                .description(course.getDescription())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
