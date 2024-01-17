package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    @Query(value = "SELECT * FROM student WHERE id=:studentCode", nativeQuery = true)
    List<Student> getAllStudentForProvidedId(@Param("studentCode") String studentCode);

    @Query(value = "SELECT COUNT(*) FROM student WHERE studentcode=:studentCode", nativeQuery = true)
    Long countAllStudentForProvidedId(@Param("studentCode") String studentCode);

    @Query(value = "SELECT * FROM student WHERE id=:studentId", nativeQuery = true)
    Student findByStudentId(@Param("studentId") String studentId);

    @Query(value = "SELECT * FROM student WHERE studentname=:studentName", nativeQuery = true)
    Optional<Student> findStudentByName(@Param("studentName") String studentName);

    @Query(value = "SELECT * FROM student WHERE id=:studentId", nativeQuery = true)
    Optional<Student> getStudentById(@Param("studentId") String studentId);

    @Query(value = "SELECT * FROM student WHERE id in (SELECT student_id FROM student_has_course WHERE course_id=:courseId)", nativeQuery = true)
    List<Student> findByStudentIdForClass(@Param("courseId") String courseId);

}
