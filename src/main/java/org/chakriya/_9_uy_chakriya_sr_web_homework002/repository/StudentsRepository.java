package org.chakriya._9_uy_chakriya_sr_web_homework002.repository;
import org.apache.ibatis.annotations.*;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Students;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.StudentRequest;
import java.util.List;

@Mapper
public interface StudentsRepository {
    @Select("SELECT * FROM students")
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number")
    })
    List<Students> getAllStudents();

    @ResultMap("studentMapper")
    @Select("SELECT * FROM students WHERE student_id = #{id}")
    Students getStudentById(Integer id);

    @Insert("INSERT INTO students (student_name, email, phone_number) VALUES (#{req.studentName}, #{req.email}, #{req.phoneNumber})")
    @Options(useGeneratedKeys = true, keyProperty = "req.studentId", keyColumn = "student_id")
    void saveStudent(@Param("req") StudentRequest request);

    @Update("UPDATE students SET student_name = #{req.studentName}, email = #{req.email}, phone_number = #{req.phoneNumber} WHERE student_id = #{id}")
    void updateStudent(@Param("id") Integer id, @Param("req") StudentRequest request);

    @Delete("DELETE FROM students WHERE student_id = #{id}")
    void deleteStudent(Integer id);
}