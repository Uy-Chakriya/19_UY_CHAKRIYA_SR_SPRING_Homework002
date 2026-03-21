package org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructors {
    private Long instructorId;
    private String instructorName;
    private String email;
}
