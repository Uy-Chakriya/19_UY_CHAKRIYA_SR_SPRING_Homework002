package org.chakriya._9_uy_chakriya_sr_web_homework002.repository;
import org.apache.ibatis.annotations.*;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Instructors;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.InstructorsResquest;
import java.util.List;

@Mapper
public interface InstructorsRepository {
    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
            @Result(property = "email", column = "email")
    })
    @Select("SELECT * FROM instructors")
    List<Instructors> getAllInstructors();

    @ResultMap("instructorMapper")
    @Select("SELECT * FROM instructors WHERE instructor_id = #{id}")
    Instructors getInstructorById(Integer id);

    @Insert("INSERT INTO instructors (instructor_name, email) VALUES (#{req.instructorName}, #{req.email})")
    @Options(useGeneratedKeys = true, keyProperty = "req.instructorId", keyColumn = "instructor_id")
    void saveInstructor(@Param("req") InstructorsResquest request);

    @Update("UPDATE instructors SET instructor_name = #{req.instructorName}, email = #{req.email} WHERE instructor_id = #{id}")
    void updateInstructor(@Param("id") Integer id, @Param("req") InstructorsResquest request);

    @Delete("DELETE FROM instructors WHERE instructor_id = #{id}")
    void deleteInstructor(Integer id);
}