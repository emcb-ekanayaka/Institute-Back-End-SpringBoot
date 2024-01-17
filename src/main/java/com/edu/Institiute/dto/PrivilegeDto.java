package com.edu.Institiute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrivilegeDto {

    private String id;
    private RoleDto roleId;
    private ModuleDto moduleId;
    private String sel;
    private String ins;
    private String upd;
    private String del;
}
