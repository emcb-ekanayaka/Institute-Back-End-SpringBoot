package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.CourseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseCourseDto {
    private Long count;
    private List<CourseResponseDto> dataList;
}
