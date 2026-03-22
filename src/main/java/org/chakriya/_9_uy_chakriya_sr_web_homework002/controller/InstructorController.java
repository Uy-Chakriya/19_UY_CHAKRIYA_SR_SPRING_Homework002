package org.chakriya._9_uy_chakriya_sr_web_homework002.controller;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Instructors;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.InstructorsResquest;
import org.chakriya._9_uy_chakriya_sr_web_homework002.service.InstructorsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController{

    private final InstructorsService instructorsService;

    @PostMapping
    public ResponseEntity<ApiResponse<Instructors>> addInstructor(@RequestBody InstructorsResquest request) {
        Instructors payload = instructorsService.saveInstructor(request);
        return ResponseEntity.ok(ApiResponse.<Instructors>Builder()
                .message("Instructor added successfully")
                .payload(payload)
                .status(HttpStatus.CONTINUE) // 100 CONTINUE per your requirement
                .timestamp(Instant.now())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructors>> getInstructorById(@PathVariable Integer id) {
        Instructors payload = instructorsService.getInstructorById(id);
        return ResponseEntity.ok(ApiResponse.<Instructors>builder()
                .message("Instructor found")
                .payload(payload)
                .status(HttpStatus.CONTINUE)
                .timestamp(Instant.now())
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructors>> updateInstructor(@PathVariable Integer id, @RequestBody InstructorRequest request) {
        instructorsService.updateInstructor(id, request);
        Instructors payload = instructorsService.getInstructorById(id);
        return ResponseEntity.ok(ApiResponse.<Instructors>builder()
                .message("Instructor updated successfully")
                .payload(payload)
                .status(HttpStatus.CONTINUE)
                .timestamp(Instant.now())
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteInstructor(@PathVariable Integer id) {
        instructorsService.deleteInstructor(id);
        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .message("Instructor removed successfully")
                .status(HttpStatus.CONTINUE)
                .timestamp(Instant.now())
                .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructors>>> getAllInstructors() {
        List<Instructors> payload = instructorsService.getAllInstructors();
        return ResponseEntity.ok(ApiResponse.<List<Instructors>>builder()
                .message("All instructors found")
                .payload(payload)
                .status(HttpStatus.CONTINUE)
                .timestamp(Instant.now())
                .build());
    }
}