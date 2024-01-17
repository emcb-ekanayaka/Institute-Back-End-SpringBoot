package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.ModuleResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseModuleDto {
    private Long count;
    private List<ModuleResponseDto> dataList;
}
