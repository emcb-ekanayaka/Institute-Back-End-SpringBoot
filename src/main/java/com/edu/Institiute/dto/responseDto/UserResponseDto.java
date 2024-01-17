package com.edu.Institiute.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
}
