package com.edu.Institiute.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class SignupRequestDto {

    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
}
