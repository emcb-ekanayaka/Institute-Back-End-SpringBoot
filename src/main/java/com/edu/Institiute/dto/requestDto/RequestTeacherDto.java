package com.edu.Institiute.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class RequestTeacherDto {
    private String id;
    private String teacherCode;
    private String teacherName;
    private String course;
    private String qualification;
}
