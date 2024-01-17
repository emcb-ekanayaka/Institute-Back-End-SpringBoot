package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.CourseService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<StandardResponse> savedCourse(@RequestBody RequestRegistryDto data){
        CommonResponseDto responseData = courseService.saveCourse(data);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("{courseId}")
    public ResponseEntity<StandardResponse> updateCourse(@RequestBody RequestRegistryDto data, @PathVariable String courseId){
        CommonResponseDto responseData = courseService.updateCourse(data,courseId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("{courseId}")
    public ResponseEntity<StandardResponse> deleteCourse(@PathVariable String courseId){
        CommonResponseDto responseData = courseService.removeCourse(courseId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping("{courseCode}")
    public ResponseEntity<StandardResponse> getCourse(@PathVariable String courseCode)throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Course List",
                        courseService.courseById(courseCode)),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllCourse()throws SQLException{
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Course List",
                        courseService.allCourse()),
                HttpStatus.OK
        );
    }
}
