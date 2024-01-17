package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StatusRepo extends JpaRepository<Status,Integer> {

    @Query(value = "SELECT * FROM status WHERE id=?1", nativeQuery = true)
    Optional<Status> findStatusById(Integer statusId);
}
