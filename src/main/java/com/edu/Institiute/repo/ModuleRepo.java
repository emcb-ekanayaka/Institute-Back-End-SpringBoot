package com.edu.Institiute.repo;
import com.edu.Institiute.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepo extends JpaRepository<Module,String> {

    @Query(value = "SELECT * FROM module as m where m.id not in(select p.module_id from privilege as p where p.roles_id=:roleName)",nativeQuery = true)
    List<Module> filteredModules(@Param("roleName") String roleName);
}
