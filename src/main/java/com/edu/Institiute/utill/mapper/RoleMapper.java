package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.RoleDto;
import com.edu.Institiute.entity.Role;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto toRoleSetDto(Role role);
    Role dtoToRoleEntity(RoleDto roleDto);
}
