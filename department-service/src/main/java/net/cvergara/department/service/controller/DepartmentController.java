package net.cvergara.department.service.controller;

import lombok.AllArgsConstructor;
import net.cvergara.department.service.dto.DepartmentDto;
import net.cvergara.department.service.repository.DepartmentRepository;
import net.cvergara.department.service.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService ;
    private final DepartmentRepository departmentRepository;

    //build save department Rest Api ;
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartmentDto(departmentDto) ;
        return new ResponseEntity<>(savedDepartment , HttpStatus.CREATED) ;
    }

    //Build get Department Rest Api ;
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>( departmentDto, HttpStatus.OK)  ;
    }
}
