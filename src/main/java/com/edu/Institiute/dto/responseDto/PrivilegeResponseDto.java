package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.ModuleDto;
import com.edu.Institiute.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrivilegeResponseDto {
    private String id;
    private RoleDto roleId;
    private ModuleDto moduleId;
    private String sel;
    private String ins;
    private String upd;
    private String del;
}
