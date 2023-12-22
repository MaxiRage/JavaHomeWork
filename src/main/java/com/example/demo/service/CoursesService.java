package com.example.demo.service;

import com.example.demo.entity.Courses;
import com.example.demo.repository.CoursesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursesService {
    private final CoursesRepository coursesRepository;

    @Transactional
    public void saveCourses(Courses courses) {
        coursesRepository.save(courses);
    }

    @Transactional
    public void deleteCourses(Courses courses) {
        coursesRepository.delete(courses);
    }

    @Transactional
    public void updateCourses(Courses courses) {
        coursesRepository.deleteById(courses.getId());
        coursesRepository.save(courses);
    }

    @Transactional
    public Optional<Courses> getCoursesById(Courses courses) {
        return coursesRepository.findById(courses.getId());
    }
}
