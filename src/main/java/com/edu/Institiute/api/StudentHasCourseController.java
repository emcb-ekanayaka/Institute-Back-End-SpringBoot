package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.repo.StudentHasCourseRepo;
import com.edu.Institiute.service.StudentHasCourseService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/student_has_course")
public class StudentHasCourseController {

    @Autowired
    private StudentHasCourseService studentHasCourseService;

    @PostMapping
    public ResponseEntity<StandardResponse> savedStudentHasCourse(@RequestBody RequestRegistryDto data){
        CommonResponseDto responseData = studentHasCourseService.saveStudentHasCourse(data);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("{studentHasCourseId}")
    public ResponseEntity<StandardResponse> updateStudentHasCourse(@RequestBody RequestRegistryDto data, @PathVariable Integer studentHasCourseId){
        CommonResponseDto responseData = studentHasCourseService.updateStudentHasCourse(data,studentHasCourseId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("{studentHasCourseId}")
    public ResponseEntity<StandardResponse> deleteStudentHasCourse(@PathVariable Integer studentHasCourseId){
        CommonResponseDto responseData = studentHasCourseService.removeStudentHasCourse(studentHasCourseId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping("{studentHasCourseId}")
    public ResponseEntity<StandardResponse> getStudentHasCourse(@PathVariable Integer studentHasCourseId)throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Student-Course List",
                        studentHasCourseService.studentHasCourseById(studentHasCourseId)),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllStudentHasCourse()throws SQLException{
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Student List",
                        studentHasCourseService.allStudentHasCourse()),
                HttpStatus.OK
        );
    }

    @GetMapping("{studentId}/{courseId}")
    public ResponseEntity<StandardResponse> getStudentHasCourseForClass(@PathVariable String studentId, @PathVariable String courseId)throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Student-Course List",
                        studentHasCourseService.allStudentHasCourseForClass(studentId,courseId)),
                HttpStatus.OK
        );
    }
}
