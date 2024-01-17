package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {

    @Query(value = "SELECT * FROM course WHERE id=:courseId", nativeQuery = true)
    Course getAllCourseForProvidedId(@Param("courseId") String courseId);

    @Query(value = "SELECT * FROM course WHERE id=:courseCode", nativeQuery = true)
    List<Course> getAllCourse(@Param("courseCode") String courseCode);

    @Query(value = "SELECT COUNT(*) FROM course WHERE coursecode=:courseCode", nativeQuery = true)
    Long countAllStudentForProvidedId(@Param("courseCode") String courseCode);

    @Query(value = "SELECT * FROM course WHERE id=:courseId", nativeQuery = true)
    Course getAllCourseForProvidedId(@Param("courseId") Integer courseId);

    @Query(value = "SELECT * FROM course WHERE coursename=:courseName", nativeQuery = true)
    Optional<Course> findCourseByName(@Param("courseName") String courseName);

    @Query(value = "SELECT * FROM course WHERE id=:courseId", nativeQuery = true)
    Optional<Course> getCourseById(@Param("courseId") String courseId);

    //SELECT c.coursename FROM institutedb.course as c where c.id NOT in (select shc.course_id from institutedb.student_has_course as shc where shc.student_id=0829);
}
