package com.edu.Institiute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {

    private String id;
    private String teacherCode;
    private String teacherName;
    private CourseDto course;
    private QualificationDto qualification;
}
