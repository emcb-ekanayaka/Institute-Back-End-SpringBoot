package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseStudentDto;

import java.sql.SQLException;

public interface StudentService {

    CommonResponseDto saveStudent(RequestRegistryDto dto);

    CommonResponseDto updateStudent(RequestRegistryDto dto, String studentId);

    CommonResponseDto removeStudent(String studentId);

    PaginatedResponseStudentDto studentById(String studentCode) throws SQLException;

    PaginatedResponseStudentDto allStudent() throws SQLException;

    PaginatedResponseStudentDto allStudentForClass(String courseCode) throws SQLException;
}
