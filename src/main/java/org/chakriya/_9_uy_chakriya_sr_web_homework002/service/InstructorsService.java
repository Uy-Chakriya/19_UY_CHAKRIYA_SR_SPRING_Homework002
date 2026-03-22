package org.chakriya._9_uy_chakriya_sr_web_homework002.service;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Instructors;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.InstructorsResquest;
import java.util.List;

public interface InstructorsService {
    List<Instructors> getAllInstructors();
    Instructors getInstructorById(Integer id);
    Instructors saveInstructor(InstructorsResquest request);
    void updateInstructor(Integer id, InstructorsResquest request);
    void deleteInstructor(Integer id);
}
