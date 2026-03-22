package org.chakriya._9_uy_chakriya_sr_web_homework002.service.Impl;
import lombok.RequiredArgsConstructor;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Courses;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.CourseRequest;
import org.chakriya._9_uy_chakriya_sr_web_homework002.repository.CoursesRepository;
import org.chakriya._9_uy_chakriya_sr_web_homework002.service.CourseService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CourseService {
    private final CoursesRepository coursesRepisitory;

    @Override
    public List<Courses> getAllCourses() {
        return coursesRepisitory.getAllCourses();
    }

    @Override
    public Courses getCourseById(Integer id) {
        return coursesRepisitory.getCourseById(id); // Implement this
    }

    @Override
    public Courses saveCourse(CourseRequest request) {
        coursesRepisitory.saveCourse(request);
        return coursesRepisitory.getCourseById(Math.toIntExact(request.getCourseId()));
    }

    @Override
    public void updateCourse(Integer id, CourseRequest request) {
        coursesRepisitory.updateCourse(id, request);
    }

    @Override
    public void deleteCourse(Integer id) {
        coursesRepisitory.deleteCourseAssociations(id);
        coursesRepisitory.deleteCourse(id);
    }
}