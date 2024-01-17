package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.CourseDto;
import com.edu.Institiute.dto.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentHasCourseResponseDto {

    private Integer id;
    private StudentDto studentId;
    private CourseDto courseId;
}
