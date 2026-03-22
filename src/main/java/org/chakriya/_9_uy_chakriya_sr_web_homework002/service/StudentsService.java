package org.chakriya._9_uy_chakriya_sr_web_homework002.service;

import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Students;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.StudentRequest;
import java.util.List;

public interface StudentsService {
    List<Students> getAllStudents();
    Students getStudentById(Integer id);
    Students saveStudent(StudentRequest request);
    void updateStudent(Integer id, StudentRequest request);
    void deleteStudent(Integer id);
}
