package org.chakriya._9_uy_chakriya_sr_web_homework002.service;

import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Courses;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.CourseRequest;
import java.util.List;

public interface CourseService {
    List<Courses> getAllCourses();
    Courses getCourseById(Integer id);
    Courses saveCourse(CourseRequest request);
    void updateCourse(Integer id, CourseRequest request);
    void deleteCourse(Integer id);
}