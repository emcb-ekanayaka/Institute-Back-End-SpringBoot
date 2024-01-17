package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.SignupRequestDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.UserSignupService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/user_sign_up")
public class UserSignupController {

    @Autowired
    private UserSignupService userSignupService;

    @PostMapping
    public ResponseEntity<StandardResponse> savedCourse(@RequestBody SignupRequestDto data){
        CommonResponseDto responseData = userSignupService.saveUser(data);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }
}
