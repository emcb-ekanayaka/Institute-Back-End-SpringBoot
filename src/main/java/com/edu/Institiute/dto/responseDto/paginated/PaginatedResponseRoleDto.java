package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.RoleResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseRoleDto {
    private Long count;
    private List<RoleResponseDto> dataList;
}
