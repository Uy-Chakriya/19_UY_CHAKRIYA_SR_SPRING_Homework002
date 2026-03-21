package org.chakriya._9_uy_chakriya_sr_web_homework002.controller;
import lombok.RequiredArgsConstructor;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Students;
import org.chakriya._9_uy_chakriya_sr_web_homework002.service.StudentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentsController {
    private final StudentsService studentsService;

    @GetMapping
    public List<Students> getAllStudents(@RequestParam(defaultValue = "1")  Integer page,
                                         @RequestParam(defaultValue = "10") Integer size){
        return StudentsService.getAllStudents(page,size);
    }

    @GetMapping("/{student-id}")
    public Students getStudentById(@PathVariable Long studentId ){
            return StudentsService.getStudentById(studentId);

    }

}
