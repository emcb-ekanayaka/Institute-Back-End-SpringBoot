package com.edu.Institiute.service.impl;


import com.edu.Institiute.dto.responseDto.RoleResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseRoleDto;
import com.edu.Institiute.entity.Role;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.RoleRepo;
import com.edu.Institiute.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class RoleImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public PaginatedResponseRoleDto allRoles() throws SQLException {
        try {
            List<Role> allRepoRoles = roleRepo.findAll();
            List<RoleResponseDto> responseDto = new ArrayList<>();

            for (Role r : allRepoRoles) {
                responseDto.add(
                        new RoleResponseDto(
                                r.getRoleName(),
                                r.getRoleDescription()
                        )
                );
            }
            return new PaginatedResponseRoleDto(
                    roleRepo.count(),
                    responseDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }
}
