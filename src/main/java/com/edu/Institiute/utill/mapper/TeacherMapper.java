package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.TeacherDto;
import com.edu.Institiute.entity.Teacher;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface TeacherMapper {

    Teacher dtoToTeacherEntity(TeacherDto teacherDto);

    TeacherDto toTeacherDto(Teacher teacher);
}
