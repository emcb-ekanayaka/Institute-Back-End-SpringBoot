package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseCourseDto;

import java.sql.SQLException;

public interface CourseService {

    CommonResponseDto saveCourse(RequestRegistryDto dto);

    CommonResponseDto updateCourse(RequestRegistryDto dto, String courseId);

    CommonResponseDto removeCourse(String courseId);

    PaginatedResponseCourseDto courseById(String courseCode) throws SQLException;

    PaginatedResponseCourseDto allCourse() throws SQLException;
}
