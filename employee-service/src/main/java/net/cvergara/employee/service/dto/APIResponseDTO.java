package net.cvergara.employee.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDTO {
    private EmployeeDto employee ;
    private DepartmentDto department ;
    private OrganizationDto organization ;
}
