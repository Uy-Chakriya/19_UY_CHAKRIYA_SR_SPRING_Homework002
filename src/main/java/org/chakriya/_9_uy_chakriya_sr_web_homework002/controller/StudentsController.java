package org.chakriya._9_uy_chakriya_sr_web_homework002.controller;
import lombok.RequiredArgsConstructor;
import org.chakriya._9_uy_chakriya_sr_web_homework002.service.StudentsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentsController {
    private final StudentsService studentsService;

}
