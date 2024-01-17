package com.edu.Institiute.api;

import com.edu.Institiute.service.CourseService;
import com.edu.Institiute.service.StatusService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<StandardResponse> getAllStatus()throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Status List",
                        statusService.allStatus()),
                HttpStatus.OK
        );
    }
}
