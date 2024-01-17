package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private User user;
    private String jwtToken;
}
