package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.StatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {

    private String id;
    private String studentCode;
    private String studentName;
    private String studentAge;
    private String studentNic;
    private StatusDto status;
}
