package com.edu.Institiute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String id;
    private String studentCode;
    private String studentName;
    private String studentAge;
    private String studentNic;
    private StatusDto status;
}
