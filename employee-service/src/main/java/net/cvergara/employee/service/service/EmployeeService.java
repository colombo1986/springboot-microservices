package net.cvergara.employee.service.service;

import net.cvergara.employee.service.dto.APIResponseDTO;
import net.cvergara.employee.service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto) ;
    APIResponseDTO getEmployeeById(Long employeeId)  ;

}
