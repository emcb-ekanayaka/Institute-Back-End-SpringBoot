package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseUserDto {
    private Long count;
    private List<UserResponseDto> dataList;
}
