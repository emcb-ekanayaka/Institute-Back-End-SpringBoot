package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, String> {

    @Query(value = "SELECT * FROM role WHERE id=:roleId", nativeQuery = true)
    Optional<Role> findRoleName(@Param("roleId") String roleId);
}
