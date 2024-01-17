package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.ModuleDto;
import com.edu.Institiute.entity.Module;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface ModuleMapper {

    ModuleDto toModuleDto(Module module);
}
