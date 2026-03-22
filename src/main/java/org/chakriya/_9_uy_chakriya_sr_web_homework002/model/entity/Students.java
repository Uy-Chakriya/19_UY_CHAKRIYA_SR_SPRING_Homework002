package org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    private Long studentId;
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Courses> courses;
}
