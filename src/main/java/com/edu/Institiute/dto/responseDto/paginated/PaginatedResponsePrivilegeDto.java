package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.PrivilegeResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponsePrivilegeDto {
    private Long count;
    private List<PrivilegeResponseDto> dataList;
}
