package com.edu.Institiute.service;

import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseRoleDto;

import java.sql.SQLException;

public interface RoleService {
    PaginatedResponseRoleDto allRoles() throws SQLException;
}
