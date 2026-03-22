package org.chakriya._9_uy_chakriya_sr_web_homework002.repository;
import org.apache.ibatis.annotations.*;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Courses;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.request.CourseRequest;
import java.util.List;

@Mapper
public interface CoursesRepository {
    @Select("SELECT * FROM courses")
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "org.chakriya._9_uy_chakriya_sr_web_homework002.repository.InstructorsRepository.getInstructorById"))
    })
    List<Courses> getAllCourses();

    @Select("SELECT * FROM courses WHERE course_id = #{id}")
    @ResultMap("courseMapper")
    Courses getCourseById(Integer id);

    @Insert("INSERT INTO courses (course_name, description, instructor_id) VALUES (#{req.courseName}, #{req.description}, #{req.instructorId})")
    @Options(useGeneratedKeys = true, keyProperty = "req.courseId", keyColumn = "course_id")
    void saveCourse(@Param("req") CourseRequest request);

    @Update("UPDATE courses SET course_name = #{req.courseName}, description = #{req.description}, instructor_id = #{req.instructorId} WHERE course_id = #{id}")
    void updateCourse(@Param("id") Integer id, @Param("req") CourseRequest request);

    @Delete("DELETE FROM student_courses WHERE course_id = #{id}")
    void deleteCourseAssociations(Integer id);

    @Delete("DELETE FROM courses WHERE course_id = #{id}")
    void deleteCourse(Integer id);
}