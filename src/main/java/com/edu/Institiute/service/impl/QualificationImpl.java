package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.responseDto.QualificationResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseQualificationDto;
import com.edu.Institiute.entity.Qualification;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.QualificationRepo;
import com.edu.Institiute.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QualificationImpl implements QualificationService {

    @Autowired
    private QualificationRepo qualificationRepo;

    @Override
    public PaginatedResponseQualificationDto allQualification() throws SQLException {
        try {
            List<Qualification> allQualifications = qualificationRepo.findAll();
            List<QualificationResponseDto> qualificationResponseDto = new ArrayList<>();

            for (Qualification r : allQualifications) {
                qualificationResponseDto.add(
                        new QualificationResponseDto(
                                r.getId(),
                                r.getQualificationName()
                        )
                );
            }
            return new PaginatedResponseQualificationDto(
                    qualificationRepo.count(),
                    qualificationResponseDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }
}
