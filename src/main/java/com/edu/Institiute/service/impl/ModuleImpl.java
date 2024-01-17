package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.responseDto.ModuleResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseModuleDto;
import com.edu.Institiute.entity.Module;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.ModuleRepo;
import com.edu.Institiute.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ModuleImpl implements ModuleService {

    @Autowired
    private ModuleRepo moduleRepo;

    @Override
    public PaginatedResponseModuleDto allModule() throws SQLException {
        try {
            List<Module> moduleList = moduleRepo.findAll();
            List<ModuleResponseDto> moduleResponseDto = new ArrayList<>();

            for (Module m : moduleList) {
                moduleResponseDto.add(
                        new ModuleResponseDto(
                                m.getId(),
                                m.getModuleName()
                        )
                );
            }
            return new PaginatedResponseModuleDto(
                    moduleRepo.count(),
                    moduleResponseDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }

    @Override
    public PaginatedResponseModuleDto allFilteredModule(String roleName) throws SQLException {
        try {
            System.out.println("AAAAAA");
            List<Module> moduleList = moduleRepo.filteredModules(roleName);
            System.out.println("BBBBBBBBBB");
            System.out.println(moduleList);
            List<ModuleResponseDto> moduleResponseDto = new ArrayList<>();

            for (Module m : moduleList) {
                moduleResponseDto.add(
                        new ModuleResponseDto(
                                m.getId(),
                                m.getModuleName()
                        )
                );
            }
            return new PaginatedResponseModuleDto(
                    moduleRepo.count(),
                    moduleResponseDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }
}
