package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.CourseDto;
import com.edu.Institiute.entity.Course;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course dtoToCourseEntity(CourseDto courseDto);

    CourseDto toCourseDto(Course student);
}
