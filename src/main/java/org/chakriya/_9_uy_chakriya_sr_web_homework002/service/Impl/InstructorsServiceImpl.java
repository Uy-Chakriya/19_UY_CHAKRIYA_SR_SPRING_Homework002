package org.chakriya._9_uy_chakriya_sr_web_homework002.service.Impl;
import lombok.RequiredArgsConstructor;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Instructors;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.InstructorsResquest;
import org.chakriya._9_uy_chakriya_sr_web_homework002.repository.InstructorsRepository;
import org.chakriya._9_uy_chakriya_sr_web_homework002.service.InstructorsService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorsServiceImpl implements InstructorsService {

    private final InstructorsRepository instructorsRepository;

    @Override
    public List<Instructors> getAllInstructors() {
        return instructorsRepository.getAllInstructors();
    }

    @Override
    public Instructors getInstructorById(Integer id) {
        return instructorsRepository.getInstructorById(id);
    }

    @Override
    public Instructors saveInstructor(InstructorsResquest request) {
        return new Instructors(
                request.getInstructorId(),
                request.getInstructorName(),
                request.getEmail()
        );
    }

    @Override
    public void updateInstructor(Integer id, InstructorsResquest request) {
        instructorsRepository.updateInstructor(id, request);
    }

    @Override
    public void deleteInstructor(Integer id) {
        instructorsRepository.deleteInstructor(id);
    }
}