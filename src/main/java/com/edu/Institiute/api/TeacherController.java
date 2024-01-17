package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.requestDto.RequestTeacherDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.TeacherService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;



@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping
    public ResponseEntity<StandardResponse> savedTeacher(@RequestBody RequestTeacherDto data){
        CommonResponseDto responseData = teacherService.saveTeacher(data);
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
    @PutMapping("{teacherId}")
    public ResponseEntity<StandardResponse> updateCourse(@RequestBody RequestTeacherDto data, @PathVariable String teacherId){
        CommonResponseDto responseData = teacherService.updateTeacher(data,teacherId);
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
    @DeleteMapping("{teacherId}")
    public ResponseEntity<StandardResponse> deleteCourse(@PathVariable String teacherId){
        CommonResponseDto responseData = teacherService.removeTeacher(teacherId);
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
    @GetMapping("{teacherId}")
    public ResponseEntity<StandardResponse> getCourse(@PathVariable String teacherId)throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Teacher List",
                        teacherService.teacherById(teacherId)),
                HttpStatus.OK
        );
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public ResponseEntity<StandardResponse> getAllTeacher()throws SQLException{
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Teacher List",
                        teacherService.allTeachers()),
                HttpStatus.OK
        );
    }
}
