package com.edu.Institiute.service;


import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseStatusDto;

import java.sql.SQLException;

public interface StatusService {

    PaginatedResponseStatusDto allStatus() throws SQLException;
}
