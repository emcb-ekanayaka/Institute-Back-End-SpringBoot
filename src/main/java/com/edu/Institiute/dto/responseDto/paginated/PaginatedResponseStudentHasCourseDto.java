package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.StudentHasCourseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseStudentHasCourseDto {
    private Long count;
    private List<StudentHasCourseResponseDto> dataList;
}
