package org.chakriya._9_uy_chakriya_sr_web_homework002.service;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Students;
import org.chakriya._9_uy_chakriya_sr_web_homework002.repository.StudentsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StudentsService {
    
    static List<Students> getAllStudents(Integer page, Integer size) {
        return StudentsRepository.getAllStudents(page, size);
    }

    static Students getStudentById(Long studentId) {
        return StudentsRepository.getStudentsByID(studentId);
    }
}
