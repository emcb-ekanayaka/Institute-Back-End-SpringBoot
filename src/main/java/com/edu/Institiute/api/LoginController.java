package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.LoginRequestDto;
import com.edu.Institiute.dto.responseDto.LoginResponseDto;
import com.edu.Institiute.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

    @Autowired
    private JwtService jwtService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping({"/authenticate"})
    public LoginResponseDto createJwtTokenAndLogin(@RequestBody LoginRequestDto loginRequestDto) throws Exception{

        return jwtService.createJwtToken(loginRequestDto);
    }

}
