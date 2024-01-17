package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.responseDto.CourseResponseDto;
import com.edu.Institiute.dto.responseDto.StatusResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseCourseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseStatusDto;
import com.edu.Institiute.entity.Course;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.repo.StudentHasCourseRepo;
import com.edu.Institiute.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StatusImpl implements StatusService {

    @Autowired
    private StatusRepo statusRepo;

    @Override
    public PaginatedResponseStatusDto allStatus() throws SQLException {
        try {
            List<Status> allStatus = statusRepo.findAll();
            List<StatusResponseDto> statusResponseDto = new ArrayList<>();

            for (Status r : allStatus) {
                statusResponseDto.add(
                        new StatusResponseDto(
                                r.getId(),
                                r.getName()
                        )
                );
            }
            return new PaginatedResponseStatusDto(
                    statusRepo.count(),
                    statusResponseDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }
}
