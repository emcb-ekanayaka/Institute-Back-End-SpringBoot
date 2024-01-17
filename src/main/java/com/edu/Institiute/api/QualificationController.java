package com.edu.Institiute.api;

import com.edu.Institiute.service.QualificationService;
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
@RequestMapping("/api/v1/qualification")
public class QualificationController {

    @Autowired
    private QualificationService qualificationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<StandardResponse> getAllQualifications()throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Status List",
                        qualificationService.allQualification()),
                HttpStatus.OK
        );
    }

}
