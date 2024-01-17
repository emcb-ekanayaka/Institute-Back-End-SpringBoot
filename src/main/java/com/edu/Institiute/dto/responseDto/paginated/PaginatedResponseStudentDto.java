package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.StudentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseStudentDto {
    private Long count;
    private List<StudentResponseDto> dataList;
}
