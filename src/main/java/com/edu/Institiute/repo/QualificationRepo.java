package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Course;
import com.edu.Institiute.entity.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface QualificationRepo extends JpaRepository<Qualification,String> {

    @Query(value = "SELECT * FROM qualification WHERE id=:qualificationId", nativeQuery = true)
    Optional<Qualification> findQualificationById(@Param("qualificationId") String qualificationId);
}
