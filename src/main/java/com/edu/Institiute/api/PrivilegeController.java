package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.PrivilegeRequestDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.PrivilegeService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/privilege")
public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeService;

    @PostMapping
    public ResponseEntity<StandardResponse> savedPrivilege(@RequestBody PrivilegeRequestDto data){
        System.out.println(data);
        CommonResponseDto responseData = privilegeService.savePrivilege(data);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("{privilegeId}")
    public ResponseEntity<StandardResponse> updatePrivilege(@RequestBody PrivilegeRequestDto data, @PathVariable String privilegeId){
        CommonResponseDto responseData = privilegeService.updatePrivilege(data,privilegeId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("getPrivilege/{privilegeCode}")
    public ResponseEntity<StandardResponse> getPrivilege(@PathVariable String privilegeCode)throws SQLException{
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Privilege List",
                        privilegeService.privilegeById(privilegeCode)),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllCourse()throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Course List",
                        privilegeService.allPrivilege()),
                HttpStatus.OK
        );
    }

    @GetMapping("/getPrivilegeForComponent/{roleName}/{moduleID}")
    public ResponseEntity<StandardResponse> getPrivilegeForComponent(@PathVariable String roleName, @PathVariable String moduleID)throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Course List",
                        privilegeService.getPrivilegeForComponent(roleName,moduleID)),
                HttpStatus.OK
        );
    }
}
