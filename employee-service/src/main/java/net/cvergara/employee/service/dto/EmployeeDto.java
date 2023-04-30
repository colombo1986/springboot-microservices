package net.cvergara.employee.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String departmentCode ;
    private String organizationCode ;
}
