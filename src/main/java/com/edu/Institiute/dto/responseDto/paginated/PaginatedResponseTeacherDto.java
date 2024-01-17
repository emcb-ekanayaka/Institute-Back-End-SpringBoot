package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.TeacherResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseTeacherDto {
    private Long count;
    private List<TeacherResponseDto> dataList;
}
