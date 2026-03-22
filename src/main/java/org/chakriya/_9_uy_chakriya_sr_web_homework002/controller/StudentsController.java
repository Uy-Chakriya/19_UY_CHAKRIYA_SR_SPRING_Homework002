package org.chakriya._9_uy_chakriya_sr_web_homework002.controller;
import lombok.RequiredArgsConstructor;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Students;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.StudentRequest;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.respones.ApiResponse;
import org.chakriya._9_uy_chakriya_sr_web_homework002.service.StudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentsController {
    private final StudentsService studentsService;
    private final String STATUS_CONTINUE = "100 CONTINUE";

    @GetMapping
    public ResponseEntity<ApiResponse<List<Students>>> getAllStudents() {
        List<Students> payload = studentsService.getAllStudents();
        return ResponseEntity.ok(ApiResponse.<List<Students>>builder()
                .message("All students found")
                .payload(payload)
                .status(STATUS_CONTINUE)
                .time(Instant.now())
                .build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Students>> addStudent(@RequestBody StudentRequest request) {
        Students payload = studentsService.saveStudent(request);
        return ResponseEntity.ok(ApiResponse.<Students>builder()
                .message("Student added successfully")
                .payload(payload)
                .status(STATUS_CONTINUE)
                .time(Instant.now())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Students>> getStudentById(@PathVariable Integer id) {
        Students payload = studentsService.getStudentById(id);
        return ResponseEntity.ok(ApiResponse.<Students>builder()
                .message("Student found")
                .payload(payload)
                .status(STATUS_CONTINUE)
                .time(Instant.now())
                .build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Students>> updateStudent(@PathVariable Integer id, @RequestBody StudentRequest request) {

        studentsService.updateStudent(id, request);
        Students payload = studentsService.getStudentById(id);

        return ResponseEntity.ok(ApiResponse.<Students>builder()
                .message("Student updated successfully")
                .payload(payload)
                .status(STATUS_CONTINUE)
                .time(Instant.now())
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable Integer id) {
        studentsService.deleteStudent(id);
        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .message("Student removed successfully")
                .status(STATUS_CONTINUE)
                .time(Instant.now())
                .build());
    }
}