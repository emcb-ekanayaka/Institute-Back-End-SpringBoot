package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.StudentService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping
    public ResponseEntity<StandardResponse> savedStudent(@RequestBody RequestRegistryDto data){
        CommonResponseDto responseData = studentService.saveStudent(data);
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
    @PutMapping("{studentId}")
    public ResponseEntity<StandardResponse> updateStudent(@RequestBody RequestRegistryDto data, @PathVariable String studentId){
        CommonResponseDto responseData = studentService.updateStudent(data,studentId);
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
    @DeleteMapping("{studentId}")
    public ResponseEntity<StandardResponse> deleteStudent(@PathVariable String studentId){
        CommonResponseDto responseData = studentService.removeStudent(studentId);
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
    @GetMapping("{studentCode}")
    public ResponseEntity<StandardResponse> getStudent(@PathVariable String studentCode)throws SQLException{
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Student List",
                        studentService.studentById(studentCode)),
                        HttpStatus.OK
        );
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public ResponseEntity<StandardResponse> getAllStudents()throws SQLException{
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Student List",
                        studentService.allStudent()),
                HttpStatus.OK
        );
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/getClass/{courseCode}")
    public ResponseEntity<StandardResponse> getStudentForClass(@PathVariable String courseCode)throws SQLException{
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Student List",
                        studentService.allStudentForClass(courseCode)),
                HttpStatus.OK
        );
    }
}
