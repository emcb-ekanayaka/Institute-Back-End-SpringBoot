package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.SignupRequestDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;

public interface UserSignupService {

    CommonResponseDto saveUser(SignupRequestDto dto);

}
