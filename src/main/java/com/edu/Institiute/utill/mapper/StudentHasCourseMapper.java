package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.StudentHasCourseDto;
import com.edu.Institiute.entity.StudentHasCourse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface StudentHasCourseMapper {
    StudentHasCourse dtoToStudentHasCourseEntity(StudentHasCourseDto studentHasCourseDto);
}
