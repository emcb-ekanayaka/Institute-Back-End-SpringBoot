package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseStudentHasCourseDto;

import java.sql.SQLException;

public interface StudentHasCourseService {

    CommonResponseDto saveStudentHasCourse(RequestRegistryDto dto);

    CommonResponseDto updateStudentHasCourse(RequestRegistryDto dto, Integer studentHasCourseId);

    CommonResponseDto removeStudentHasCourse(Integer studentHasCourseId);

    PaginatedResponseStudentHasCourseDto studentHasCourseById(Integer studentHasCourseId) throws SQLException;

    PaginatedResponseStudentHasCourseDto allStudentHasCourse() throws SQLException;

    PaginatedResponseStudentHasCourseDto allStudentHasCourseForClass(String studentId, String courseId) throws SQLException;
}
