package net.cvergara.employee.service.service;

import net.cvergara.employee.service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080/" , value = "DEPARTMENT-SERVICE")
public interface APIClient {

    //Build get Department Rest Api ;
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode)  ;
}
