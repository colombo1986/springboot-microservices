package net.cvergara.department.service.service;

import net.cvergara.department.service.dto.DepartmentDto;
import net.cvergara.department.service.entity.Department;

import java.util.Optional;

public interface DepartmentService {
    DepartmentDto saveDepartmentDto( DepartmentDto departmentDto) ;
    DepartmentDto getDepartmentByCode(String code) ;

}
