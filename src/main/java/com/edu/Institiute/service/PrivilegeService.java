package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.PrivilegeRequestDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponsePrivilegeDto;

import java.sql.SQLException;

public interface PrivilegeService {

    CommonResponseDto savePrivilege(PrivilegeRequestDto dto);

    CommonResponseDto updatePrivilege(PrivilegeRequestDto dto, String privilegeId);

    PaginatedResponsePrivilegeDto privilegeById(String privilegeCode) throws SQLException;

    PaginatedResponsePrivilegeDto allPrivilege() throws SQLException;

    PaginatedResponsePrivilegeDto getPrivilegeForComponent(String roleName,String moduleID) throws SQLException;
}
