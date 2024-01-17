package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.StatusDto;
import com.edu.Institiute.entity.Status;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusDto toStatusDto(Status status);
    Status dtoToStatus(StatusDto status);
}
