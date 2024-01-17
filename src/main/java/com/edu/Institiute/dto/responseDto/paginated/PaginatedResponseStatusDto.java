package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.StatusResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseStatusDto {
    private Long count;
    private List<StatusResponseDto> dataList;
}
