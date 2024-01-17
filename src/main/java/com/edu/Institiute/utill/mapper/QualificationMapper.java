package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.QualificationDto;
import com.edu.Institiute.entity.Qualification;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface QualificationMapper {

    Qualification dtoToQualificationEntity(QualificationDto qualificationDto);

    QualificationDto toQualificationDto(Qualification qualification);
}
