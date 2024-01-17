package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.PrivilegeDto;
import com.edu.Institiute.entity.Privilege;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface PrivilegeMapper {

    Privilege dtoToPrivilegeEntity(PrivilegeDto privilegeDto);

    PrivilegeDto toPrivilegeDto(Privilege privilege);
}
