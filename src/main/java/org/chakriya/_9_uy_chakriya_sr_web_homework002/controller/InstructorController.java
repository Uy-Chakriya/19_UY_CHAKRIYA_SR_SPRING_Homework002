package org.chakriya._9_uy_chakriya_sr_web_homework002.controller;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Students;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.StudentRequest;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.respones.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Instructors;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.InstructorsResquest;
import org.chakriya._9_uy_chakriya_sr_web_homework002.service.InstructorsService;
import org.chakriya._9_uy_chakriya_sr_web_homework002.service.StudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorsService instructorsService;
    private final String STATUS_CONTINUE = "100 CONTINUE";
    private final StudentsService studentsService;

    @PostMapping
    public ResponseEntity<ApiResponse<Students>> addStudent(@RequestBody StudentRequest request) {
        Students payload = studentsService.saveStudent(request);
        return ResponseEntity.ok(ApiResponse.<Students>builder()
                .message("Student added successfully")
                .payload(payload)
                .status("100 CONTINUE")
                .time(Instant.now())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructors>> getInstructorById(@PathVariable Integer id) {
        Instructors payload = instructorsService.getInstructorById(id);
        return ResponseEntity.ok(ApiResponse.<Instructors>builder()
                .message("Instructor found")
                .payload(payload)
                .status(STATUS_CONTINUE)
                .time(Instant.now())
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructors>> updateInstructor(@PathVariable Integer id, @RequestBody InstructorsResquest request) {
        instructorsService.updateInstructor(id, request);
        Instructors payload = instructorsService.getInstructorById(id);
        return ResponseEntity.ok(ApiResponse.<Instructors>builder()
                .message("Instructor updated successfully")
                .payload(payload)
                .status(STATUS_CONTINUE)
                .time(Instant.now())
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteInstructor(@PathVariable Integer id) {
        instructorsService.deleteInstructor(id);
        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .message("Instructor removed successfully")
                .status(STATUS_CONTINUE)
                .time(Instant.now())
                .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructors>>> getAllInstructors() {
        List<Instructors> payload = instructorsService.getAllInstructors();
        return ResponseEntity.ok(ApiResponse.<List<Instructors>>builder()
                .message("All instructors found")
                .payload(payload)
                .status(STATUS_CONTINUE)
                .time(Instant.now())
                .build());
    }
}