package com.edu.Institiute.repo;

import com.edu.Institiute.entity.StudentHasCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentHasCourseRepo extends JpaRepository<StudentHasCourse, Integer> {

    @Query(value = "SELECT * FROM student_has_course WHERE student_id=:studentId", nativeQuery = true)
    List<StudentHasCourse> getStudentAndCourse(@Param("studentId") String studentId);

    @Query(value = "SELECT * FROM student_has_course WHERE course_id=:courseId", nativeQuery = true)
    List<StudentHasCourse> getCourseAndStudent(@Param("courseId") String courseId);

    @Query(value = "SELECT * FROM student_has_course WHERE id=:studentHasCourseId", nativeQuery = true)
    StudentHasCourse findByStudentHasCourse(@Param("studentHasCourseId") Integer studentHasCourseId);

    @Query(value = "SELECT * FROM student_has_course WHERE id=:studentHasCourseId", nativeQuery = true)
    List<StudentHasCourse> getAllStudentCourse(@Param("studentHasCourseId") Integer studentHasCourseId);

    @Query(value = "SELECT * FROM student_has_course WHERE student_id=:studentId And course_id=:courseId", nativeQuery = true)
    List<StudentHasCourse> getAllStudentHasCourse(@Param("studentId") String studentId, @Param("courseId") String courseId);


}
