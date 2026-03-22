package org.chakriya._9_uy_chakriya_sr_web_homework002.repository;
import org.apache.ibatis.annotations.*;
import org.chakriya._9_uy_chakriya_sr_web_homework002.model.entity.Students;
import java.util.List;

@Mapper
public interface StudentsRepository {

//    @Results(id = "studentMapper", value = {
//            @Result(property = "studentId", column = "student_id"),
//            @Result(property = "studentName", column = "student_name"),
//            @Result(property = "phoneNumber", column = "phone_number"),
//    })
//
//    @ResultMap("studentMapper")
//    @Select("""
//        select * from students LIMIT #{size} OFFSET #{offset}
//
//""")
//    static List<Students> getAllStudents(Integer offset, Integer size) {
//        return getAllStudents(offset, size);
//    }
//
//
//    @ResultMap("studentMapper")
//    @Select("""
//        select * from students where id = #{studentId}
//""")
//    static Students getStudentsByID(Long studentId) {
//        return getStudentsByID(studentId) ;
//
//}

}
