package org.chakriya._9_uy_chakriya_sr_web_homework002.service.Impl;
import lombok.RequiredArgsConstructor;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Students;
import org.chakriya._9_uy_chakriya_sr_web_homework002.repository.StudentsRepository;
import org.chakriya._9_uy_chakriya_sr_web_homework002.service.StudentsService;
import java.util.List;

@RequiredArgsConstructor
public class StudentsServiceImpl implements StudentsService {
    private final StudentsRepository studentsRepository;

    public List<Students> getAllStudents(Integer page, Integer size){
            Integer offset = (page - 1) * size;
            return StudentsRepository.getAllStudents(offset, size);
    }

}
