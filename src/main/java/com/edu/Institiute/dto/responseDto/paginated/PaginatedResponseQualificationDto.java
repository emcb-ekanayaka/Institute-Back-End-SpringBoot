package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.QualificationResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseQualificationDto {

    private Long count;
    private List<QualificationResponseDto> dataList;
}
