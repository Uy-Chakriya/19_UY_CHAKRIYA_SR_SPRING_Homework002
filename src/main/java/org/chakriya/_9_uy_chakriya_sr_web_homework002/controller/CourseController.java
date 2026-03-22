package org.chakriya._9_uy_chakriya_sr_web_homework002.controller;
import lombok.RequiredArgsConstructor;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Courses;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.CourseRequest;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.respones.ApiResponse;
import org.chakriya._9_uy_chakriya_sr_web_homework002.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final String STATUS_CONTINUE = "100 CONTINUE";

    @GetMapping
    public ResponseEntity<ApiResponse<List<Courses>>> getAllCourses() {
        List<Courses> payload = courseService.getAllCourses();
        return ResponseEntity.ok(ApiResponse.<List<Courses>>builder()
                .message("All courses found")
                .payload(payload)
                .status(STATUS_CONTINUE)
                .time(Instant.now())
                .build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Courses>> addCourse(@RequestBody CourseRequest request) {
        Courses payload = courseService.saveCourse(request);
        return ResponseEntity.ok(ApiResponse.<Courses>builder()
                .message("Course added successfully")
                .payload(payload)
                .status(STATUS_CONTINUE)
                .time(Instant.now())
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Courses>> updateCourse(@PathVariable Integer id, @RequestBody CourseRequest request) {
        courseService.updateCourse(id, request);
        Courses payload = courseService.getCourseById(id);
        return ResponseEntity.ok(ApiResponse.<Courses>builder()
                .message("Course updated successfully")
                .payload(payload)
                .status(STATUS_CONTINUE)
                .time(Instant.now())
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .message("Course removed successfully")
                .status(STATUS_CONTINUE)
                .time(Instant.now())
                .build());
    }
}