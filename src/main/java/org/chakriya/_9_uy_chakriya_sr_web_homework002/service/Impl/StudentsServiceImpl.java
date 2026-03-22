package org.chakriya._9_uy_chakriya_sr_web_homework002.service.Impl;

import lombok.RequiredArgsConstructor;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Students;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.StudentRequest;
import org.chakriya._9_uy_chakriya_sr_web_homework002.repository.StudentsRepository;
import org.chakriya._9_uy_chakriya_sr_web_homework002.service.StudentsService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentsServiceImpl implements StudentsService {
    private final StudentsRepository studentsRepository;

    @Override
    public List<Students> getAllStudents() {
        return studentsRepository.getAllStudents();
    }

    @Override
    public Students getStudentById(Integer id) {
        return studentsRepository.getStudentById(id);
    }

    @Override
    public Students saveStudent(StudentRequest request) {
        studentsRepository.saveStudent(request);
        return new Students(
                request.getStudentId(),
                request.getStudentName(),
                request.getEmail(),
                request.getPhoneNumber(),
                null
        );
    }

    @Override
    public void updateStudent(Integer id, StudentRequest request) {
        studentsRepository.updateStudent(id, request);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentsRepository.deleteStudent(id);
    }
}
