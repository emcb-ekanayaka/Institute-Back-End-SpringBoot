package com.edu.Institiute.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrivilegeRequestDto {
    private String id;
    private String roleId;
    private String moduleId;
    private String sel;
    private String ins;
    private String upd;
    private String del;
}
