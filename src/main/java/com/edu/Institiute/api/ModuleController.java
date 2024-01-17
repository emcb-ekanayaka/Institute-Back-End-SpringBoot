package com.edu.Institiute.api;

import com.edu.Institiute.service.ModuleService;
import com.edu.Institiute.service.QualificationService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<StandardResponse> getAllModules()throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Module List",
                        moduleService.allModule()),
                HttpStatus.OK
        );
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("{roleName}")
    public ResponseEntity<StandardResponse> getFilteredModules(@PathVariable String roleName)throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Filtered Module List",
                        moduleService.allFilteredModule(roleName)),
                HttpStatus.OK
        );
    }
}
