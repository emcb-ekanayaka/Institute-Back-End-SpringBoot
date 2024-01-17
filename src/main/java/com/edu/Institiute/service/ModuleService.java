package com.edu.Institiute.service;

import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseModuleDto;

import java.sql.SQLException;

public interface ModuleService {
    PaginatedResponseModuleDto allModule() throws SQLException;

    PaginatedResponseModuleDto allFilteredModule(String roleName) throws SQLException;
}
