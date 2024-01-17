package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.CourseDto;
import com.edu.Institiute.dto.QualificationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponseDto {

    private String id;
    private String teacherCode;
    private String teacherName;
    private CourseDto course;
    private QualificationDto qualification;
}
