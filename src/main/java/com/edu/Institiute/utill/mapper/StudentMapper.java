package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.StudentDto;
import com.edu.Institiute.entity.Student;
import org.springframework.stereotype.Repository;
import org.mapstruct.Mapper;

@Repository
@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student dtoToStudentEntity(StudentDto studentDto);

    StudentDto toStudentDto(Student student);
}
