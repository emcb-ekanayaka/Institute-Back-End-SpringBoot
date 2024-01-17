package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TeacherRepo extends JpaRepository<Teacher,String> {

    @Query(value = "SELECT * FROM teacher WHERE id=:teacherId", nativeQuery = true)
    Teacher findByTeacherId(@Param("teacherId") String teacherId);

    @Query(value = "SELECT * FROM teacher WHERE id=:teacherId", nativeQuery = true)
    List<Teacher> getAllTeachersForProvidedId(@Param("teacherId") String teacherId);

}
