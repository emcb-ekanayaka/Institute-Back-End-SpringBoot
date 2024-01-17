package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestTeacherDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseTeacherDto;

import java.sql.SQLException;

public interface TeacherService {

    CommonResponseDto saveTeacher(RequestTeacherDto dto);

    CommonResponseDto updateTeacher(RequestTeacherDto dto, String teacherId);

    CommonResponseDto removeTeacher(String teacherId);

    PaginatedResponseTeacherDto teacherById(String teacherId) throws SQLException;

    PaginatedResponseTeacherDto allTeachers() throws SQLException;
}
