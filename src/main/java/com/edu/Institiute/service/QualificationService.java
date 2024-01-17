package com.edu.Institiute.service;

import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseQualificationDto;

import java.sql.SQLException;

public interface QualificationService {

    PaginatedResponseQualificationDto allQualification() throws SQLException;
}
