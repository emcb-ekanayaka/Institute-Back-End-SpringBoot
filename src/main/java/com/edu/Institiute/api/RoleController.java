package com.edu.Institiute.api;

import com.edu.Institiute.service.QualificationService;
import com.edu.Institiute.service.RoleService;
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
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<StandardResponse> getAllRoles()throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Role List",
                        roleService.allRoles()),
                HttpStatus.OK
        );
    }
}
